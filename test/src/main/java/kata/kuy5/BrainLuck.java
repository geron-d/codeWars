package kata.kuy5;

import java.util.ArrayList;
import java.util.List;

public class BrainLuck {
    public List<Character> cpu;
    public String code;
    public int pointer = 0;

    public BrainLuck(String code) {
        this.code = code;
        cpu = new ArrayList<>();
    }

    public String process(String input) {
        for (int i = 0; i < 5000; i++) {
            cpu.add((char) 0);
        }


        char[] codeChar = code.toCharArray();
        char[] inputChar = input.toCharArray();
        int inputPointer = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < codeChar.length; i++) {
            if (codeChar[i] == '>') {
                if (pointer == cpu.size() - 1) {
                    pointer = 0;
                } else {
                    pointer++;
                }
            } else if (codeChar[i] == '<') {
                if (pointer == 0) {
                    pointer = cpu.size() - 1;
                } else {
                    pointer--;
                }
            } else if (codeChar[i] == '+') {
                cpu.set(pointer, (char) (cpu.get(pointer) + 1));
                if (cpu.get(pointer) > 255) {
                    cpu.set(pointer, (char) 0);
                }
            } else if (codeChar[i] == '-') {
                cpu.set(pointer, (char) (cpu.get(pointer) - 1));
                if (cpu.get(pointer) < 0) {
                    cpu.set(pointer, (char) 255);
                }
            } else if (codeChar[i] == ',') {
                cpu.set(pointer, inputChar[inputPointer]);
                inputPointer++;
            } else if (codeChar[i] == '.') {
                sb.append(cpu.get(pointer));
            } else if (codeChar[i] == '[') {
                if (cpu.get(pointer) == 0) {
                    int nesting = 0;
                    i++;
                    while (codeChar[i] != ']' || nesting != 0) {
                        if (codeChar[i] == '[') {
                            nesting++;
                        } else if (codeChar[i] == ']') {
                            nesting--;
                        }
                        i++;
                    }
                }
            } else if (codeChar[i] == ']') {
                if (cpu.get(pointer) != 0) {
                    int nesting = 0;
                    i--;
                    while (codeChar[i] != '[' || nesting != 0) {
                        if (codeChar[i] == ']') {
                            nesting++;
                        }
                        if (codeChar[i] == '[') {
                            nesting--;
                        }
                        i--;
                    }
                    i--;
                }
            }
        }

        return sb.toString();
    }
}
