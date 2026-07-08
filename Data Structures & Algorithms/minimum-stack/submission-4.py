class MinStack:

    def __init__(self):
        self.stack=[]
        self.minVal = float('inf')

    def push(self, val: int) -> None:
        if not self.stack:
            self.stack.append(0)
            self.minVal = val
        else: 
            self.stack.append(val-self.minVal)
            self.minVal = min(val, self.minVal)

    def pop(self) -> None:
        if not self.stack: return

        pop = self.stack.pop()
        if pop<0:
            self.minVal = self.minVal - pop

    def top(self) -> int:
        top = self.stack[-1]
        if top < 0:
            return self.minVal
        return self.stack[-1] + self.minVal
        

    def getMin(self) -> int:
        return self.minVal
        
