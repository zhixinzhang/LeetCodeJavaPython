
class _1249_MinimumRemovetoMakeValidParentheses_Stack:
    def minRemoveToMakeValid(self, s: str) -> str:
        stack = []
        indexs_to_remove = set()

        for i, c in enumerate(s):
            if c not in "()":
                continue
            if c == "(":
                stack.append(c)
            elif not stack:
                indexs_to_remove.add(i)
            else:
                stack.pop
        
        indexs_to_remove = indexs_to_remove.union(set(stack))
        string_builder = []
        for i, c in enumerate(s):
            if i not in indexs_to_remove:
                string_builder.append(c)
        return "".join(string_builder)