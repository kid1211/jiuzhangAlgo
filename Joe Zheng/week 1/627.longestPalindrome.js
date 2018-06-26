/**
 * @param s: a string which consists of lowercase or uppercase letters
 * @return: the length of the longest palindromes that can be built
 */
const longestPalindrome = function(s) {
  var couples = 0;
  if (s == null || s == undefined) return 0;
  var originalLength = s.length;
  if (originalLength <= 0) return 0;

  while (s.length > 0) {
    var checkElemnt = s[0];
    s = s.substring(1);

    for (var i = 0; i < s.length; i++) {
      // console.log(checkElemnt, s);
      if (s[i] == checkElemnt) {
        // console.log("match");
        couples++;
        var temp = s;
        // console.log("***debug before:", s);
        s = temp.substring(0, i) + temp.substring(i + 1);
        // console.log("***debug after:", s);

        // Force the for loop to end and skip to the next while
        i = s.length;
      }
    }
  }

  let maxDuplicate = couples * 2 + 1;
  return maxDuplicate > originalLength ? maxDuplicate - 1 : maxDuplicate;
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
  // console.log("10.cdzdc: ", longestPalindrome("abcdzdcab"));
  // console.log("10.cdzdc: ", longestPalindrome("abcdzdcab"));
  // console.log("11.cddc: ", longestPalindrome("abcddcab"));
  // console.log("12.a: ", longestPalindrome("a"));
  // console.log("13.bb: ", longestPalindrome("bb"));
  console.log("13. 9: ", longestPalindrome("aabccccdd"));
  console.log("13. 7: ", longestPalindrome("abccccdd"));
  console.log("13. 9: ", longestPalindrome("abcccacdd"));
};

main();
