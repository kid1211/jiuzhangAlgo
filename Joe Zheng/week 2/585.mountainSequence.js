/**
 * @param nums: a mountain sequence which increase firstly and then decrease
 * @return: then mountain top
 */
const mountainSequence = function(nums) {
  if (nums == undefined || nums.length == 0) {
    return -1;
  }
  let left = 0;
  let right = nums.length - 1;

  if (right == 0) {
    return nums[left];
  }

  while (left + 1 < right) {
    let mid = Math.floor((left + right) / 2);
    if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
      return nums[mid];
    } else if (nums[mid] > nums[mid - 1]) {
      left = mid + 1;
    } else {
      right = mid - 1;
    }
  }

  if (nums[left] > nums[left + 1]) {
    return nums[left];
  }

  if (nums[right] > nums[right - 1]) {
    return nums[right];
  }
};
(function() {
  console.log("\nLet's go!\n");
  console.log("1: ", 8 == mountainSequence([1, 2, 4, 8, 6, 3]));
  console.log("2: ", 10 == mountainSequence([10, 9, 8, 7]));
  console.log("3: ", 60 == mountainSequence([60]));
  console.log("4: ", -1 == mountainSequence([]));
  console.log("4: ", -1 == mountainSequence());
})();
