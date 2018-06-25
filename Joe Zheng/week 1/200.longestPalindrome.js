/**
 * @param s: input string
 * @return: the longest palindromic substring
 */
const longestPalindrome = function(s) {
  if (s === undefined) return "";
  if (s.length <= 1) return s;
  s = s.replace(/[^a-zA-Z0-9]+/g, "").toLowerCase();
  let longest = "";

  for (let i = 0; i < s.length; i++) {
    let longestOdd = helpFindPalindrome(s, i - 1, i + 1);
    let longestEven = helpFindPalindrome(s, i - 1, i);
    let tempLongest =
      longestOdd.length > longestEven.length ? longestOdd : longestEven;

    if (longest.length < tempLongest.length) {
      longest = tempLongest;
    }
  }

  return longest;
};

const helpFindPalindrome = function(s, left, right) {
  let longest = right - left == 2 ? s[left + 1] : "";

  while (left >= 0 && right <= s.length) {
    if (s[left] != s[right]) {
      // console.log("debug1", s[left], s[right]);
      return longest;
    } else {
      longest = s[left] + longest + s[right];
      // console.log("debug2", longest, s[left], s[right]);
      left--;
      right++;
    }
  }

  // catch uncaught error
  return longest;
};

const main = () => {
  // console.log("\n\n1.false: ", longestPalindrome());
  // console.log("2.true: ", longestPalindrome(""));
  // console.log("3.false: ", longestPalindrome("abc"));
  // console.log("*4.false: ", longestPalindrome("123321"));
  // console.log("5.true: ", longestPalindrome("abcba"));
  // console.log("6.true: ", longestPalindrome("A man, a plan, a canal: Panama"));
  // console.log("7.false: ", longestPalindrome("ab"));
  // console.log("8.false: ", longestPalindrome("race a car"));
  // console.log("9.true: ", longestPalindrome("a"));
  console.log("10.cdzdc: ", longestPalindrome("abcdzdcab"));
  console.log("10.cdzdc: ", longestPalindrome("abcdzdcab"));
  console.log("11.cddc: ", longestPalindrome("abcddcab"));
  console.log("12.a: ", longestPalindrome("a"));
  console.log("13.bb: ", longestPalindrome("bb"));
  // console.log("13.bb: ", helpFindPalindrome("bb", 0, 1));
};

main();
