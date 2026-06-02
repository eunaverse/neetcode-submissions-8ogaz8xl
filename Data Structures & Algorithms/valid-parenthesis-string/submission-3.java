class Solution {
        public boolean checkValidString(String s) {
                Stack<Integer> openStk = new Stack<>();
                        Stack<Integer> starStk = new Stack<>();

                                int idx = 0;
                                        for (char c : s.toCharArray()) {
                                                    if (c == '(') openStk.push(idx++);
                                                                else if (c == '*') starStk.push(idx++);
                                                                            else {
                                                                                            if (!openStk.isEmpty()) {
                                                                                                                openStk.pop();
                                                                                                                                } else if (!starStk.isEmpty()) {
                                                                                                                                                    starStk.pop();
                                                                                                                                                                    } else return false;
                                                                                                                                                                                }
                                                                                                                                                                                        }
                                                                                                                                                                                                while (!openStk.isEmpty()) {
                                                                                                                                                                                                            if (starStk.isEmpty()) return false;
                                                                                                                                                                                                                        if (starStk.peek() < openStk.peek()) return false;
                                                                                                                                                                                                                                    openStk.pop();
                                                                                                                                                                                                                                                starStk.pop();
                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                return true;

                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                    }
