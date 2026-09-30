class Solution:
    def decodeString(self, s: str) -> str:
        num_stack = []
        string_stack = []
        cur = ""
        k = 0

        for c in s:
            if c.isdigit():
                k = k*10 + int(c)
            elif c == '[':
                num_stack.append(k)
                string_stack.append(cur)
                cur = ""
                k = 0
            elif c == ']':
                repeat = num_stack.pop()
                tmp = string_stack.pop()
                for i in range(repeat):
                    tmp += cur
                cur = tmp
            else:
                cur += c
        return cur