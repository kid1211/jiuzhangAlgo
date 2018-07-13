/**
 * @param A: an integer array
 * @param target: An integer
 * @param k: An integer
 * @return: an integer array
 */
const kClosestNumbers = function(A, target, k) {
  if (A === undefined || k > A.length || k <= 0) {
    return [];
  }
  if (A.length <= 1) {
    return A;
  }

  let left = 0;
  let right = A.length - 1;
  let closest = -1;
  let mid = -1;
  while (left + 1 < right) {
    mid = Math.floor(left + (right - left) / 2);

    if (A[mid] == target) {
      closest = mid;
      break;
    } else if (A[mid] > target) {
      right = mid;
    } else {
      left = mid;
    }
  }

  if (closest == -1) {
    closest = A[right] - target >= target - A[left] ? left : right;
  }

  left = closest - 1;
  right = closest + 1;

  let rtnArray = [A[closest]];
  while (rtnArray.length < k) {
    // console.log(
    //   "array ",
    //   JSON.stringify(rtnArray),
    //   A[right] - target,
    //   target - A[left]
    // );
    let leftDistance = target - A[left];
    let rightDistance = A[right] - target;

    if (rightDistance >= leftDistance || right >= A.length) {
      rtnArray.push(A[left]);
      left--;
    } else {
      rtnArray.push(A[right]);
      right++;
    }

    // console.log(JSON.stringify(rtnArray), leftDistance, rightDistance);
  }

  //   console.log("array ", JSON.stringify(rtnArray));
  return rtnArray;
};

(function() {
  console.log("\nLet's go!\n");
  console.log(
    "0: ",
    JSON.stringify([2]) == JSON.stringify(kClosestNumbers([1, 2, 3], 2, 1))
  );
  console.log(
    "1: ",
    JSON.stringify([2, 1, 3]) ==
      JSON.stringify(kClosestNumbers([1, 2, 3], 2, 3))
  );
  console.log(
    "2: ",
    JSON.stringify([4, 1, 6]) ==
      JSON.stringify(kClosestNumbers([1, 4, 6, 8], 3, 3))
  );
  console.log(
    "3: ",
    JSON.stringify([2, 1, 6]) ==
      JSON.stringify(kClosestNumbers([1, 2, 6, 8], 3, 3))
  );
  console.log(
    "4: ",
    JSON.stringify([2, 4, 1]) ==
      JSON.stringify(kClosestNumbers([1, 2, 4, 8], 3, 3))
  );
  console.log(
    "5: ",
    JSON.stringify([4, 1, 0]) ==
      JSON.stringify(kClosestNumbers([0, 1, 4, 8], 3, 3))
  );
  console.log(
    "5: ",
    JSON.stringify([20, 10, 6, 4]) ==
      JSON.stringify(kClosestNumbers([1, 4, 6, 10, 20], 21, 4))
  );
  console.log(
    "6: ",
    JSON.stringify([1, 4, 6, 10]) ==
      JSON.stringify(kClosestNumbers([1, 4, 6, 10, 20], 1, 4))
  );
  console.log(
    "7: ",
    JSON.stringify([20, 22, 23, 25]) ==
      JSON.stringify(kClosestNumbers([20, 22, 23, 25, 28], 21, 4))
  );
  console.log(
    "8: ",
    JSON.stringify([12, 8, 16, 4]) ==
      JSON.stringify(kClosestNumbers([1, 4, 8, 12, 16, 28, 38], 12, 4))
  );
  console.log(
    "9: ",
    JSON.stringify([]) ==
      JSON.stringify(kClosestNumbers([1, 2, 4, 5, 6, 7, 8, 10], 5, 0))
  );
})();

// 1,1,1,1,1,2,4
