/**
 * @param {number[]} nums
 * @return {number}
 */
var removeDuplicates = function (nums) {
    let i = 1;
    let j = 1;
    while (j < nums.length) {
        if (nums[j] !== nums[i-1]) {
            nums[i] = nums[j];
            i++;
        }
        j++;
    }
    return i;
};

console.log(removeDuplicates([1, 1, 2]) === 2);
console.log(removeDuplicates([0, 0, 1, 1, 1, 2, 2, 3, 3, 4]) === 5);
