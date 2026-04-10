"""Linear Regression Example

This program demonstrates linear regression implementation in two ways:
1. Manual implementation using gradient descent
2. Using scikit-learn library

The example includes generating sample data, training the model,
and visualizing the results.
"""

import numpy as np
import matplotlib.pyplot as plt
from sklearn.linear_model import LinearRegression
from sklearn.metrics import r2_score

class SimpleLinearRegression:
    def __init__(self, learning_rate=0.01, iterations=1000):
        self.learning_rate = learning_rate
        self.iterations = iterations
        self.weights = None
        self.bias = None
        
    def fit(self, X, y):
        n_samples = len(X)
        self.weights = 0
        self.bias = 0
        
        # Gradient descent
        for _ in range(self.iterations):
            # Make predictions
            y_pred = self.weights * X + self.bias
            
            # Calculate gradients
            dw = (-2/n_samples) * np.sum(X * (y - y_pred))
            db = (-2/n_samples) * np.sum(y - y_pred)
            
            # Update parameters
            self.weights -= self.learning_rate * dw
            self.bias -= self.learning_rate * db
            
    def predict(self, X):
        return self.weights * X + self.bias

def main():
    # Generate sample data
    np.random.seed(42)
    X = 2 * np.random.rand(100, 1)
    y = 4 + 3 * X + np.random.randn(100, 1) * 0.1

    # Flatten arrays
    X = X.flatten()
    y = y.flatten()

    # Custom implementation
    custom_model = SimpleLinearRegression(learning_rate=0.01, iterations=1000)
    custom_model.fit(X, y)
    custom_predictions = custom_model.predict(X)

    # Scikit-learn implementation
    sklearn_model = LinearRegression()
    sklearn_model.fit(X.reshape(-1, 1), y)
    sklearn_predictions = sklearn_model.predict(X.reshape(-1, 1))

    # Plotting results
    plt.figure(figsize=(12, 6))
    
    # Plot original data
    plt.scatter(X, y, color='blue', label='Data points')
    
    # Plot custom implementation prediction line
    plt.plot(X, custom_predictions, color='red', label='Custom Implementation')
    
    # Plot scikit-learn prediction line
    plt.plot(X, sklearn_predictions, color='green', label='Scikit-learn')
    
    plt.title('Linear Regression: Custom vs Scikit-learn Implementation')
    plt.xlabel('X')
    plt.ylabel('y')
    plt.legend()
    
    # Print results
    print("\nCustom Implementation:")
    print(f"Weights: {custom_model.weights:.4f}")
    print(f"Bias: {custom_model.bias:.4f}")
    
    print("\nScikit-learn Implementation:")
    print(f"Weights: {sklearn_model.coef_[0]:.4f}")
    print(f"Bias: {sklearn_model.intercept_:.4f}")
    
    # Calculate and print R² scores
    custom_r2 = r2_score(y, custom_predictions)
    sklearn_r2 = r2_score(y, sklearn_predictions)
    
    print(f"\nR² Score (Custom): {custom_r2:.4f}")
    print(f"R² Score (Scikit-learn): {sklearn_r2:.4f}")
    
    plt.show()

if __name__ == "__main__":
    main() 