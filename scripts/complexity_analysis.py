import time
import random
import numpy as np
import matplotlib.pyplot as plt
from scipy.optimize import curve_fit

# QuickSort implementation (3-way Dutch National Flag)
def quicksort(nums, low, high, depth_counter):
    depth_counter[0] = max(depth_counter[0], high - low + 1)  # track max recursion depth proxy

    if low >= high:
        return

    pivot_index = random.randint(low, high)
    pivot = nums[pivot_index]
    i = low
    j = high
    k = low

    while k <= j:
        if nums[k] < pivot:
            nums[i], nums[k] = nums[k], nums[i]
            i += 1
            k += 1
        elif nums[k] > pivot:
            nums[k], nums[j] = nums[j], nums[k]
            j -= 1
        else:
            k += 1

    quicksort(nums, low, i - 1, depth_counter)
    quicksort(nums, j + 1, high, depth_counter)

def sort_and_measure(arr):
    nums = arr.copy()
    depth_counter = [0]
    start = time.perf_counter()
    quicksort(nums, 0, len(nums) - 1, depth_counter)
    end = time.perf_counter()
    return end - start, depth_counter[0]

# Complexity models
def constant(n, a):
    return np.full_like(n, a, dtype=float)

def linear(n, a, b):
    return a * n + b

def nlogn(n, a, b):
    return a * n * np.log2(n + 1) + b

def quadratic(n, a, b):
    return a * n * n + b

def logarithmic(n, a, b):
    return a * np.log2(n + 1) + b


def fit_and_score(func, x, y, name):
    """Fit a model and return R² score with parameters."""
    try:
        popt, _ = curve_fit(func, x, y, maxfev=10000)
        predicted = func(x, *popt)
        ss_res = np.sum((y - predicted) ** 2)
        ss_tot = np.sum((y - np.mean(y)) ** 2)
        r2 = 1 - (ss_res / ss_tot) if ss_tot > 0 else 0
        return {'name': name, 'func': func, 'params': popt, 'r2': r2, 'predicted': predicted}
    except Exception as e:
        return {'name': name, 'func': func, 'params': None, 'r2': -np.inf, 'error': str(e)}


def determine_complexity(sizes, data, data_label):
    """Determine the best-fitting complexity class for given data."""
    sizes_np = np.array(sizes, dtype=float)
    data_np = np.array(data)

    models = {
        'O(1)': constant,
        'O(log n)': logarithmic,
        'O(n)': linear,
        'O(n log n)': nlogn,
        'O(n²)': quadratic
    }

    results = []
    for name, func in models.items():
        result = fit_and_score(func, sizes_np, data_np, name)
        results.append(result)

    # Sort by R² score
    results.sort(key=lambda x: x['r2'], reverse=True)

    print(f"\n--- {data_label} ---")
    for r in results:
        if r['r2'] > -np.inf:
            print(f"  {r['name']}: R² = {r['r2']:.6f}")
        else:
            print(f"  {r['name']}: Failed to fit - {r.get('error', 'unknown')}")

    best = results[0]

    # Additional validation: check if normalized data is constant
    # For O(n log n), T/(n log n) should be roughly constant
    # For O(n²), T/n² should be roughly constant
    validation = validate_complexity(sizes_np, data_np, best['name'])

    return best, validation


def validate_complexity(sizes, data, complexity_name):
    """Validate complexity by checking if normalized data is constant."""
    if complexity_name == 'O(n log n)':
        normalized = data / (sizes * np.log2(sizes))
    elif complexity_name == 'O(n²)':
        normalized = data / (sizes ** 2)
    elif complexity_name == 'O(n)':
        normalized = data / sizes
    elif complexity_name == 'O(log n)':
        normalized = data / np.log2(sizes)
    elif complexity_name == 'O(1)':
        normalized = data
    else:
        return {'valid': False, 'reason': 'Unknown complexity'}

    # Check coefficient of variation (CV) - lower is more constant
    cv = np.std(normalized) / np.mean(normalized) if np.mean(normalized) != 0 else np.inf

    # CV < 0.3 suggests reasonably constant (allowing for noise)
    is_valid = cv < 0.3

    return {
        'valid': is_valid,
        'cv': cv,
        'normalized_mean': np.mean(normalized),
        'normalized_std': np.std(normalized)
    }


def determine_space_complexity(sizes, depths):
    """Determine space complexity based on recursion depth measurements."""
    sizes_np = np.array(sizes, dtype=float)
    depths_np = np.array(depths, dtype=float)

    # For quicksort, space is determined by recursion depth
    # Average case: O(log n), Worst case: O(n)

    models = {
        'O(log n)': logarithmic,
        'O(n)': linear,
        'O(1)': constant
    }

    results = []
    for name, func in models.items():
        result = fit_and_score(func, sizes_np, depths_np, name)
        results.append(result)

    results.sort(key=lambda x: x['r2'], reverse=True)

    print("\n--- Space Complexity (Recursion Depth) ---")
    for r in results:
        if r['r2'] > -np.inf:
            print(f"  {r['name']}: R² = {r['r2']:.6f}")

    return results[0]

# Test sizes
sizes = [100, 500, 1000, 2000, 5000, 10000, 20000, 50000, 100000]
num_trials = 5

# Collect data
times_random = []
times_sorted = []
times_reverse = []
depths_random = []
depths_sorted = []
depths_reverse = []

print("Measuring performance...")
for n in sizes:
    print(f"  n = {n}")

    # Random arrays
    t_sum, d_sum = 0, 0
    for _ in range(num_trials):
        arr = [random.randint(0, n) for _ in range(n)]
        t, d = sort_and_measure(arr)
        t_sum += t
        d_sum += d
    times_random.append(t_sum / num_trials)
    depths_random.append(d_sum / num_trials)

    # Already sorted
    t_sum, d_sum = 0, 0
    for _ in range(num_trials):
        arr = list(range(n))
        t, d = sort_and_measure(arr)
        t_sum += t
        d_sum += d
    times_sorted.append(t_sum / num_trials)
    depths_sorted.append(d_sum / num_trials)

    # Reverse sorted
    t_sum, d_sum = 0, 0
    for _ in range(num_trials):
        arr = list(range(n, 0, -1))
        t, d = sort_and_measure(arr)
        t_sum += t
        d_sum += d
    times_reverse.append(t_sum / num_trials)
    depths_reverse.append(d_sum / num_trials)

# Convert to numpy
sizes_np = np.array(sizes, dtype=float)
times_random_np = np.array(times_random)
times_sorted_np = np.array(times_sorted)
times_reverse_np = np.array(times_reverse)

# Programmatically determine time complexity for each case
time_random_result, time_random_validation = determine_complexity(sizes, times_random, "Time Complexity (Random Input - Average Case)")
time_sorted_result, time_sorted_validation = determine_complexity(sizes, times_sorted, "Time Complexity (Sorted Input)")
time_reverse_result, time_reverse_validation = determine_complexity(sizes, times_reverse, "Time Complexity (Reverse Sorted Input)")

# Programmatically determine space complexity
space_random_result = determine_space_complexity(sizes, depths_random)
space_sorted_result = determine_space_complexity(sizes, depths_sorted)
space_reverse_result = determine_space_complexity(sizes, depths_reverse)

# Use random case as the best fit for plotting
best_fit = (time_random_result['name'], time_random_result['func'], time_random_result['params'])
best_r2 = time_random_result['r2']

print(f"\nBest fit for average case: {best_fit[0]} with R² = {best_r2:.6f}")

# Plot time complexity
fig, axes = plt.subplots(2, 2, figsize=(14, 10))

# Plot 1: Time vs Size (all cases)
ax1 = axes[0, 0]
ax1.plot(sizes, times_random, 'bo-', label='Random', markersize=6)
ax1.plot(sizes, times_sorted, 'g^-', label='Sorted', markersize=6)
ax1.plot(sizes, times_reverse, 'rs-', label='Reverse', markersize=6)

# Add best fit line
if best_fit:
    x_smooth = np.linspace(min(sizes), max(sizes), 100)
    y_fit = best_fit[1](x_smooth, *best_fit[2])
    ax1.plot(x_smooth, y_fit, 'k--', label=f'Fit: {best_fit[0]}', linewidth=2)

ax1.set_xlabel('Array Size (n)')
ax1.set_ylabel('Time (seconds)')
ax1.set_title('QuickSort Time Complexity')
ax1.legend()
ax1.grid(True, alpha=0.3)

# Plot 2: Log-log plot
ax2 = axes[0, 1]
ax2.loglog(sizes, times_random, 'bo-', label='Random', markersize=6)
ax2.loglog(sizes, times_sorted, 'g^-', label='Sorted', markersize=6)
ax2.loglog(sizes, times_reverse, 'rs-', label='Reverse', markersize=6)

# Reference lines
n_ref = np.array(sizes)
scale = times_random[-1] / (sizes[-1] * np.log2(sizes[-1]))
ax2.loglog(n_ref, scale * n_ref * np.log2(n_ref), 'k--', label='O(n log n) reference', alpha=0.7)

ax2.set_xlabel('Array Size (n)')
ax2.set_ylabel('Time (seconds)')
ax2.set_title('QuickSort Time Complexity (Log-Log Scale)')
ax2.legend()
ax2.grid(True, alpha=0.3)

# Plot 3: Time / (n log n) - should be constant for O(n log n)
ax3 = axes[1, 0]
normalized_random = [t / (n * np.log2(n)) for t, n in zip(times_random, sizes)]
normalized_sorted = [t / (n * np.log2(n)) for t, n in zip(times_sorted, sizes)]
normalized_reverse = [t / (n * np.log2(n)) for t, n in zip(times_reverse, sizes)]

ax3.plot(sizes, normalized_random, 'bo-', label='Random', markersize=6)
ax3.plot(sizes, normalized_sorted, 'g^-', label='Sorted', markersize=6)
ax3.plot(sizes, normalized_reverse, 'rs-', label='Reverse', markersize=6)
ax3.axhline(y=np.mean(normalized_random), color='b', linestyle='--', alpha=0.5)

ax3.set_xlabel('Array Size (n)')
ax3.set_ylabel('Time / (n log n)')
ax3.set_title('Normalized Time (should be constant for O(n log n))')
ax3.legend()
ax3.grid(True, alpha=0.3)

# Plot 4: Space complexity (recursion depth proxy)
ax4 = axes[1, 1]
ax4.plot(sizes, depths_random, 'bo-', label='Random', markersize=6)
ax4.plot(sizes, depths_sorted, 'g^-', label='Sorted', markersize=6)
ax4.plot(sizes, depths_reverse, 'rs-', label='Reverse', markersize=6)

# Log n reference
log_ref = [np.log2(n) * 50 for n in sizes]  # scaled for visibility
ax4.plot(sizes, log_ref, 'k--', label='O(log n) reference (scaled)', alpha=0.7)

ax4.set_xlabel('Array Size (n)')
ax4.set_ylabel('Max Subarray Size During Recursion')
ax4.set_title('Space Complexity Indicator (Recursion Depth)')
ax4.legend()
ax4.grid(True, alpha=0.3)

plt.tight_layout()
plt.savefig('quicksort_complexity_analysis.png', dpi=150)
plt.show()

# Programmatic Summary
print("\n" + "="*60)
print("COMPLEXITY ANALYSIS SUMMARY (PROGRAMMATICALLY DETERMINED)")
print("="*60)

print("\nTIME COMPLEXITY:")
print(f"  Random Input (Average):  {time_random_result['name']} (R² = {time_random_result['r2']:.4f}, CV = {time_random_validation['cv']:.4f})")
print(f"  Sorted Input:            {time_sorted_result['name']} (R² = {time_sorted_result['r2']:.4f}, CV = {time_sorted_validation['cv']:.4f})")
print(f"  Reverse Sorted Input:    {time_reverse_result['name']} (R² = {time_reverse_result['r2']:.4f}, CV = {time_reverse_validation['cv']:.4f})")

# Determine observed worst case
all_time_results = [
    ('Random', time_random_result),
    ('Sorted', time_sorted_result),
    ('Reverse', time_reverse_result)
]
# Find which case has highest complexity (worst performance)
complexity_order = {'O(1)': 0, 'O(log n)': 1, 'O(n)': 2, 'O(n log n)': 3, 'O(n²)': 4}
worst_case = max(all_time_results, key=lambda x: complexity_order.get(x[1]['name'], 0))
best_case = min(all_time_results, key=lambda x: complexity_order.get(x[1]['name'], 0))

print(f"\n  Observed Best Case:  {best_case[0]} input -> {best_case[1]['name']}")
print(f"  Observed Worst Case: {worst_case[0]} input -> {worst_case[1]['name']}")

print("\nSPACE COMPLEXITY (based on recursion depth):")
print(f"  Random Input:         {space_random_result['name']} (R² = {space_random_result['r2']:.4f})")
print(f"  Sorted Input:         {space_sorted_result['name']} (R² = {space_sorted_result['r2']:.4f})")
print(f"  Reverse Sorted Input: {space_reverse_result['name']} (R² = {space_reverse_result['r2']:.4f})")

print("\nVALIDATION:")
print(f"  Time complexity validation (CV < 0.3 is good):")
print(f"    Random:  {'PASS' if time_random_validation['valid'] else 'FAIL'} (CV = {time_random_validation['cv']:.4f})")
print(f"    Sorted:  {'PASS' if time_sorted_validation['valid'] else 'FAIL'} (CV = {time_sorted_validation['cv']:.4f})")
print(f"    Reverse: {'PASS' if time_reverse_validation['valid'] else 'FAIL'} (CV = {time_reverse_validation['cv']:.4f})")

print("\nINTERPRETATION:")
# Provide interpretation based on results
if time_random_result['name'] == 'O(n log n)' and time_random_validation['valid']:
    print("  - Average case time complexity is O(n log n) as expected for quicksort")
if time_sorted_result['name'] == time_reverse_result['name'] == time_random_result['name']:
    print("  - Random pivot selection successfully prevents worst-case on sorted inputs")
elif complexity_order.get(time_sorted_result['name'], 0) > complexity_order.get(time_random_result['name'], 0):
    print("  - WARNING: Sorted input shows worse complexity - pivot selection may need improvement")

if space_random_result['name'] == 'O(n)':
    print("  - Space complexity is O(n) - consider tail recursion optimization")
elif space_random_result['name'] == 'O(log n)':
    print("  - Space complexity is O(log n) as expected for balanced partitions")

print("="*60)