const nums = [2, 7, 11, 15];
const target = 9;

/**
 * Finds indexes of array items such they add up to target
 * The algorithm:
 * When we iterate through the array, we check the dictionary for complement.
 * @param nums
 * @param target
 */
const twoSum = (nums, target) => {
    const complements = {};
    for (let i = 0; i < nums.length; i++) {
        const complement = target - nums[i];
        if (complements.hasOwnProperty(complement)) {
            return [i, complements[complement]]
        } else {
            complements[nums[i]] = i;
        }
    }
    return [];
}

console.log(twoSum(nums, target));