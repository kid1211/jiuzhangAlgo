/**
 * @param num: An integer
 * @return: an integer array
 * @description:
 *   1. 不需要判定k是否为质数，如果k不为质数，且能整出n时，n早被k的因数所除。故能整除n的k必是质数。
 *   2. 为何引入up？为了优化性能。当k大于up时，k已不可能整除n，除非k是n自身。也即为何步骤5判断n是否为1，n不为1时必是比up大的质数。
 *   3. 步骤2中，也判定n是否为1，这也是为了性能，当n已为1时，可早停。
 */

const primeFactorization = function(num) {
  var rtn = [];
  var maxFac = Math.sqrt(num);

  if (num === undefined || num === null || num === 0 || isNaN(num)) {
    return [];
  }

  if (num == 1) {
    return [1];
  }

  for (var i = 2; i <= maxFac && num > 1; i++) {
    while (num % i === 0) {
      num /= i;
      rtn.push(i);
    }
  }

  if (num != 1) {
    rtn.push(num);
  }

  return rtn;
};

const main = function() {
  //   console.log("1: ", primeFactorization(10).equals([2, 2, 3, 5, 11]));

  console.log(
    "1: ",
    JSON.stringify([2, 5]) == JSON.stringify(primeFactorization(10))
  );
  console.log(
    "2: ",
    JSON.stringify([2, 2, 3, 5, 11]) == JSON.stringify(primeFactorization(660))
  );
  console.log(
    "3: ",
    JSON.stringify([7]) == JSON.stringify(primeFactorization(7))
  );

  console.log(
    "4: ",
    JSON.stringify([1]) == JSON.stringify(primeFactorization(1))
  );

  console.log(
    "5: ",
    JSON.stringify([]) == JSON.stringify(primeFactorization("yo"))
  );
  console.log(
    "6: ",
    JSON.stringify([]) == JSON.stringify(primeFactorization(0))
  );
  console.log(
    "6: ",
    JSON.stringify([1000000007]) ==
      JSON.stringify(primeFactorization(1000000007))
  );
};

main();
