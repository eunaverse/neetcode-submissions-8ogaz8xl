from collections import deque

class Codec:
    
    def serialize(self, root: Optional[TreeNode]) -> str:
        if not root:
            return "N"

        res = []
        que = deque([root])

        while que:
            node = que.popleft()

            if not node:
                res.append("N")
            else:
                res.append(str(node.val))
                que.append(node.left)
                que.append(node.right)

        return ",".join(res)
        
    def deserialize(self, data: str) -> Optional[TreeNode]:
        vals = iter(data.split(","))

        val = next(vals)
        if val == "N":
            return None

        root = TreeNode(int(val))
        que = deque([root])

        while que:
            node = que.popleft()

            val = next(vals)
            if val != "N":
                node.left = TreeNode(int(val))
                que.append(node.left)

            val = next(vals)
            if val != "N":
                node.right = TreeNode(int(val))
                que.append(node.right)

        return root