/**
 * @param {String}  s : A string
 * @returns {Boolean} :Whether the string is a valid palindrome
 */
const isPalindrome = function(s) {
  if (s === undefined) return false;
  if (s.length <= 1) return true;
  s = s.replace(/[^a-zA-Z0-9]+/g, "").toLowerCase();
  // if (len % 2 == 0) return false;

  for (var i = 0; i < s.length / 2; i++) {
    console.log("iter:", s[i], s[s.length - 1 - i]);
    if (s[i] !== s[s.length - 1 - i]) return false;
  }
  return true;
};

const main = () => {
  // console.log("1.false: ", isPalindrome());
  // console.log("2.true: ", isPalindrome(""));
  // console.log("3.false: ", isPalindrome("abc"));
  console.log("4.false: ", isPalindrome("123321"));
  console.log("5.true: ", isPalindrome("abcba"));
  console.log("6.true: ", isPalindrome("A man, a plan, a canal: Panama"));
  // console.log("7.false: ", isPalindrome("ab"));
  // console.log("8.false: ", isPalindrome("race a car"));
  // console.log("9.false: ", isPalindrome("1a2"));
};

main();
