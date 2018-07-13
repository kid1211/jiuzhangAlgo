/**
 * @param nums: a rotated sorted array
 * @return: the minimum number in the array
 */
const findMin = function(nums) {
  if (nums === null || nums === undefined || nums.length <= 0) {
    return null;
  }

  if (nums.length == 1) {
    return nums[0];
  }

  let left = 0;
  let right = nums.length - 1;

  while (left + 1 < right) {
    let mid = Math.floor(left + (right - left) / 2);

    if (nums[mid] < nums[mid - 1]) {
      //   console.log(left, mid, right);
      //   console.log(nums[left], nums[mid], nums[right]);
      return nums[mid];
    }

    if (nums[right] > nums[mid]) {
      right = mid;
    } else if (nums[left] < nums[mid]) {
      left = mid;
    } else {
      //   console.log(left, mid, right);
      //   console.log(nums[left], nums[mid], nums[right]);
      return null;
    }
  }

  return nums[left] < nums[right] ? nums[left] : nums[right];
};

(function() {
  console.log("\nLet's go!\n");
  console.log("1: ", 0 == findMin([1, 2, 4, 8, 9, 0]));
  console.log("2: ", 1 == findMin([5, 6, 7, 9, 1, 2]));
  console.log("3: ", 60 == findMin([60]));
  console.log("4: ", null == findMin([]));
  console.log("4: ", null == findMin());
  console.log("2: ", 0 == findMin([4, 5, 6, 7, 0, 1, 2]));
  console.log("1: ", 1 == findMin([1, 2, 4, 8, 9, 10]));
  console.log("1: ", 1 == findMin([1, 2]));
  console.log("1: ", 1 == findMin([1, 2]));
})();
