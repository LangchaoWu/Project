#include <iostream>
#include <math.h>
#include <vector>
#include<cmath>
using namespace std;

class Bond
{
public:
	Bond(double F, double issue_date, int num_periods, int freq,
		const std::vector<double> &c) {
		if (F >= 0) { _Face = F; }
		if (freq >= 1) { _cpnFreq = freq; }
		if (num_periods >= 1) { _numCpnPeriods = num_periods; }
		_issue = issue_date;
		_maturity = _issue + _numCpnPeriods / _cpnFreq;
		_cpnAmt.resize(_numCpnPeriods);
		_cpnDate.resize(_numCpnPeriods);
		for (int i = 0; i < _numCpnPeriods; i++) {
			_cpnDate[i] = (double)(i + 1) / _cpnFreq;
		}
		setCoupons(c);

	}
	~Bond() {
		_cpnAmt.clear();
		_cpnDate.clear();
	}
	void setFlatCoupons(double c) {
		if (c < 0.0) c = 0.0;
		std::fill(_cpnAmt.begin(), _cpnAmt.end(), c);
	}
	void setCoupons(const std::vector<double> &c) {
		for (int i = 0; i < _cpnAmt.size(); i++) {
			if (i <c.size()) {
				if (c[i] < 0) {
					_cpnAmt[i] = 0;
				}
				else { _cpnAmt[i] = c[i]; }

			}
			else {
				if (c.back() < 0) {
					_cpnAmt[i] = 0;
				}
				else {
					_cpnAmt[i] = c.back();
				}
			}

		}
	}

	double FairValue(double t0, double y) const {
		double B = 0;
		double dummy1 = 0;
		double dummy2 = 0;
		FV_duration(t0, y, B, dummy1, dummy2);
		return B;
	}
	double maturity() const { return _maturity; }
	double issue() const { return _issue; }

	int FV_duration(double t0, double y, double &B,
		double &Mac_dur, double &mod_dur) const {
		B = 0;
		Mac_dur = 0;
		mod_dur = 0;
		y = y * 0.01;
		if (t0 < _issue || t0 >= _maturity) { 
			return 1;
		}
		const double tol = 1.0e-6;
		for (int i = 0; i < _cpnAmt.size(); i++) {
			if (_cpnDate[i] >= (t0 + tol)) {
				if (i == _cpnAmt.size() - 1) {
					B = B + (_Face + _cpnAmt[i] / _cpnFreq) / pow((1 + y / _cpnFreq), _cpnFreq*(_cpnDate[i] - t0));
				}
				else {
					B = B + (_cpnAmt[i] / _cpnFreq) / pow((1 + y / _cpnFreq), _cpnFreq*(_cpnDate[i] - t0));
				}
			}

		}

		for (int i = 0; i < _cpnAmt.size(); i++) {
			if (_cpnDate[i] >= (t0 + tol)) {
				if (i == _cpnAmt.size() - 1) {
					Mac_dur = Mac_dur + (_cpnDate[i] - t0)*(_Face + _cpnAmt[i] / _cpnFreq) / pow((1 + y / _cpnFreq), _cpnFreq*(_cpnDate[i] - t0));
				}
				else {
					Mac_dur = Mac_dur + (_cpnDate[i] - t0)*(_cpnAmt[i] / _cpnFreq) / pow((1 + y / _cpnFreq), _cpnFreq*(_cpnDate[i] - t0));
				}
			}
		}
		Mac_dur = Mac_dur / B;
		mod_dur = Mac_dur / (1 + y / _cpnFreq);
		return 0;


	}

private:
	// data
	double _Face;
	double _issue;
	double _maturity;
	int _cpnFreq;
	int _numCpnPeriods;
	std::vector<double> _cpnAmt;
	std::vector<double> _cpnDate;
};
int yield(double &y, int &num_iter, const Bond &bond, double B_target, double t0,
	double tol = 1.0e-4, int max_iter = 100) {
	y = 0;
	num_iter = 0;
	if (B_target <= 0.0 || t0 < bond.issue() || t0 >= bond.maturity()) {
		return 1;
	}
	double y_low = 0.0;
	double y_high = 100.0;
	double B_y_low = bond.FairValue(t0, y_low);
	double diff_B_y_low = B_y_low - B_target;
	if (abs(diff_B_y_low) <= tol) {
		y = y_low;
		cout << "when B_target =  " << B_target << "  ,  " << "y = " << y << "%" << endl;
		return 0;
	}
	else {
		double B_y_high = bond.FairValue(t0, y_high);
		double diff_B_y_high = B_y_high - B_target;
		if (abs(diff_B_y_high) <= tol) {
			y = y_high;
			cout << "when B_target =  " << B_target << "  ,  " << "y = " << y << "%" << endl;
			return 0;
		}
		else {
			if (diff_B_y_high *diff_B_y_low > 0) {
				y = 0;
				return 1;
			}
			else {
				for (num_iter = 1; num_iter < max_iter; ++num_iter) {
					y = (y_high + y_low) / 2.0;
					double b = bond.FairValue(t0, y);
					double b_diff = b - B_target;
					if (abs(b_diff) <= tol) {
						cout << "when B_target =  " << B_target << "  ,  " << "y = " << y << "%" << endl;
						cout << "num_iter =  " << num_iter << endl;
						return 0;
					}
					else {
						if (b_diff * diff_B_y_low > 0) {
							y_low = y;
						}
						else {
							y_high = y;
						}
						if (abs(y_high - y_low) <= tol) {
							cout << "when B_target =  " << B_target << "  ,  " << "y = " << y << "%" << endl;
							cout << "num_iter =  " << num_iter << endl;
							return 0;
						}
					}

				}
				y = 0;
				return 1;

			}
		}
	}
}
int main() {
	double id = 23387910;
	vector<double> c = { 2.0,3.0,3.0,8.0,7.0,9.0,1.0,0.0 };
	
	Bond a(100.0, 0.0, 8, 2, c);
	cout << "B  = " << a.FairValue(0.5, 5.0) << endl;
	//For hw1 q3;
	Bond b(100.0, 0.0, 8, 2, c);
	b.setFlatCoupons(4.0); 
    cout << "B  = "<< b.FairValue(0.0, 0.0) << endl;
	cout << "B  = " << b.FairValue(0.0, 2.0) << endl;
	cout << "B  = " << b.FairValue(0.0, 4.0) << endl;
	cout << "B  = " << b.FairValue(0.0, 6.0) << endl;
	cout << "B  = " << b.FairValue(0.0, 8.0) << endl;
	double b_target = 100.5;
	
	double y;
	int n;
	double tol = 1.0e-4;
	double iter = 100;
	double t0 = 0.0;
	yield(y, n, a, b_target, t0, tol, iter);
    b_target = 100 + id * 1.0e-8;
	/*t0 = 0.5;
	yield(y, n, a, b_target, t0, tol, iter);*/
	a.~Bond();
	return 0;

}
