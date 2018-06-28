/**
 * @param nums: An integer array sorted in ascending order
 * @param target: An integer
 * @return: An integer
 */
const lastPosition = function(nums, target) {
  let left = 0;
  let right = nums.length - 1;

  while (left + 1 < right) {
    let mid = Math.floor((left + right) / 2);
    // console.log("debug: ", mid);
    if (nums[mid] == target) {
      for (var i = mid; i <= right; i++) {
        if (nums[i] != target) {
          return i - 1;
        }
      }

      return isNextPosition(nums, right, target);
    } else if (nums[mid] > target) {
      right = mid;
    } else {
      left = mid;
    }
  }

  if (nums[left] == target) {
    return isNextPosition(nums, right, target);
  }

  if (nums[right] == target) {
    return right;
  }

  return -1;
};

const isNextPosition = function(nums, right, target) {
  if (nums[right] == target) {
    return right;
  }
  return right - 1;
};

(function() {
  console.log("\nLet's go!\n");
  let temp = [0, 1, 2, 3, 4, 5];
  console.log("1: ", 2 == lastPosition(temp, 2));
  console.log("2: ", 5 == lastPosition(temp, 5));
  console.log("3: ", -1 == lastPosition(temp, 6));
  temp = [1, 2, 2, 4, 5, 5];
  console.log("4: ", 2 == lastPosition(temp, 2));
  console.log("5: ", 5 == lastPosition(temp, 5));
  console.log("6: ", -1 == lastPosition(temp, 6));
})();
// (function() {
//   console.log("I am here");
// })();
