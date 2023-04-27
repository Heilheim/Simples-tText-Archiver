public class SimplestTextArchiver {
    public static void main(String[] args) {
        String source = "A".repeat(22) + "B".repeat(11) + "C".repeat(3);
        System.out.println("Source text:   " + source);

        String zipped = zip(source);
        System.out.println("Zipped text:   " + zipped);

        String unzipped = unzip(zipped);
        System.out.println("Unzipped text: " + unzipped);
    }

        private static String zip(String source) {
            StringBuilder zippedSource = new StringBuilder();
            int count = 1;
            char ch = source.charAt(0);

            for (int i = 1; i < source.length(); i++) {
                if (ch == source.charAt(i)) {
                    count++;
                } else {
                    zippedSource.append(ch).append(count);
                    count = 1;
                    ch = source.charAt(i);
                }
            }
            zippedSource.append(ch).append(count);
            return zippedSource.toString();
        }

        private static String unzip(String zipped) {
            int count = 0;
            for (int i = 0; i < zipped.length(); i++) {
                if (!Character.isDigit(zipped.charAt(i))){
                    count++;
                }
            }

            String[] lettersArray = new String[count];
            int lettersArrayElement = 0;
            String[] numbersArray = new String[count];
            int numbersArrayElement = -1;
            StringBuilder repeatNumber = new StringBuilder();

            for (int i = 0; i < zipped.length(); i++) {
                if (!Character.isDigit(zipped.charAt(i))){
                    lettersArray[lettersArrayElement] = Character.toString(zipped.charAt(i));
                    lettersArrayElement++;
                    numbersArrayElement++;
                    numbersArray[numbersArrayElement] = "";
                } else {
                    numbersArray[numbersArrayElement] += Character.toString(zipped.charAt(i));
                }
            }

            StringBuilder unzippedSource = new StringBuilder();
            for (int i = 0; i < lettersArray.length; i++) {
                unzippedSource.append(lettersArray[i].repeat(Integer.parseInt(numbersArray[i])));
            }

            return unzippedSource.toString();
        }
    }

