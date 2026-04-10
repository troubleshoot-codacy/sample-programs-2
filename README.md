# Linear Regression Example

This project demonstrates linear regression implementation in Python using two approaches:
1. A custom implementation using gradient descent
2. Using scikit-learn's built-in LinearRegression

## Features
- Custom linear regression implementation from scratch
- Comparison with scikit-learn implementation
- Data visualization using matplotlib
- Performance metrics (R² score) comparison

## Requirements
- Python 3.7+
- Dependencies listed in requirements.txt

## Installation
```bash
pip install -r requirements.txt
```

## Usage
Simply run the Python script:
```bash
python linear_regression.py
```

The script will:
1. Generate sample data
2. Train both models (custom and scikit-learn)
3. Display a plot comparing both implementations
4. Print model parameters and R² scores

## Output
The program will display:
- A plot showing the original data points and regression lines
- Model parameters (weights and bias) for both implementations
- R² scores for both models

## Implementation Details
The custom implementation uses gradient descent to minimize the mean squared error between predictions and actual values. The scikit-learn implementation uses its optimized algorithm for comparison. 