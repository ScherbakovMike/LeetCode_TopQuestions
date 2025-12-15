class Solution:
    def minWindow(self, s1: str, s2: str) -> str:

        pos1_1 = s1.find(s2[0], 0, len(s1))
        pos1_2 = s1.rfind(s2[len(s2)-1], 0, len(s1))

        if (
                pos1_1 == -1
                or pos1_2 == -1
        ):
            return ""
        min_1 = pos1_1
        min_2 = self.__s2_in_s1(s1, min_1, pos1_2+1, s2)
        min_len = min_2 - min_1 + 1

        pos1_1_new = s1.find(s2[0], pos1_1 + 1, pos1_2 + 1)
        while pos1_1_new != -1:
            # looking for the first end of the required string
            pos1_2_new = self.__s2_in_s1(s1, pos1_1_new, pos1_2+1, s2)
            if pos1_2_new==-1:
                break
            else:
                if (pos1_2_new-pos1_1_new+1)<min_len:
                    min_1 = pos1_1_new
                    min_2 = pos1_2_new
                    min_len = min_2 - min_1 + 1
                pos1_1_new = s1.find(s2[0], pos1_1_new + 1, pos1_2 + 1)

        return s1[min_1: min_2 + 1]

    def __s2_in_s1(self, s1: str, pos1_1: int, pos1_2: int, s2: str) -> int:
        next_pos = s1.find(s2[0], pos1_1, pos1_2)
        if next_pos == -1:
            return -1
        for pos2_1 in range(1, len(s2)):
            next_pos = s1.find(s2[pos2_1], next_pos + 1, pos1_2)
            if next_pos == -1:
                return -1

        return next_pos


def test3():
    s1 = "abcdebdde"
    s2 = "bde"
    solution = Solution()
    result = solution.minWindow(s1, s2)
    print(f"s1 = {s1}")
    print(f"s2 = {s2}")
    print(f"Result: {result}")


if __name__ == "__main__":
    test3()
