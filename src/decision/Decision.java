package decision;

import stat.Text;

public class Decision {
    private static StringBuilder stringBuilder;
    private static char[] alphabet = {'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з', 'и', 'й', 'к', 'л', 'м', 'н',
                                        'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я'};
    private static char[] alphabetHigh = {'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ё', 'Ж', 'З', 'И', 'Й', 'К', 'Л', 'М', 'Н',
                                        'О', 'П', 'Р', 'С', 'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Ъ', 'Ы', 'Ь', 'Э', 'Ю', 'Я'};

    public static void decision() {
        solve();
    }

    private static void solve() {
        for(int offerStep = 0; offerStep <= 33; offerStep++) {
            stringBuilder = new StringBuilder();
            for(int j = 0; j < Text.TEXT.length(); j++) {
                char symbol = Text.TEXT.charAt(j);
                if(!characterCheck(symbol)) {
                    insertALetter(symbol, offerStep);
                }
            }
            writeResult();
        }
    }

    private static boolean characterCheck(char symbol) {
        if(symbol == ' ') {
            stringBuilder.append(' ');
            return true;
        }
        if(symbol == ',') {
            stringBuilder.append(',');
            return true;
        }
        if(symbol == '.') {
            stringBuilder.append('.');
            return true;
        }
        return false;
    }

    private static void insertALetter(char symbol, int offerStep) {
        int index = 0;
        if((int)symbol >= 1072) {
            for (; index < alphabet.length; index++)
                if(alphabet[index] == symbol)
                    break;
            if(index - offerStep < 0)
                stringBuilder.append(alphabet[33 + index - offerStep]);
            else
                stringBuilder.append(alphabet[index - offerStep]);
        }
        else {
            for (; index < alphabetHigh.length; index++)
                if(alphabetHigh[index] == symbol)
                    break;
            if(index - offerStep < 0)
                stringBuilder.append(alphabetHigh[33 + index - offerStep]);
            else
                stringBuilder.append(alphabetHigh[index - offerStep]);
        }
    }

    private static void writeResult() {
        System.out.println(stringBuilder);
        System.out.println();
        System.out.println("-------------------------------------------");
        System.out.println();
    }
}