package javapro.dz8;


public class ArrayValueCalculator {
    public static int doCalc(String[][] array) throws ArraySizeException, ArrayDataException {
        if (array.length != 4 || array[0].length != 4) {
            throw new ArraySizeException(", треба зробити розмір матриці 4 x 4!");
        }

        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException ex) {
                    throw new ArrayDataException("невірні дані масиву [" + i + "][" + j + "]: " + array[i][j], ex);
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {

        //пробуємо із свідомо невалідним розміром масива
        try {
            int result = doCalc(new String[][]{{"1", "a", "3", "4"}, {"5", "6", "7", "8"}, {"9", "10", "11", "12"}});
            System.out.println(result);
        } catch (ArraySizeException | ArrayDataException ex) {
            System.out.println("Невалідний розмір масива" + ex.getMessage());
        }

        //пробуемо із свідомо невалідними даними в масиві
        try {
            int result = doCalc(new String[][]{{"1", "2", "3", "4"}, {"5", "6", "#", "8"}, {"9", "10", "11", "12"}, {"9", "10", "11", "12"}});
            System.out.println(result);
        } catch (ArraySizeException | ArrayDataException exception) {
            System.out.println("Свідомо невалідні дані в масиві: " + exception.getMessage());
        }

        //пробуємо валідні данні
        try {
            int result = doCalc(new String[][]{{"1", "2", "3", "4"}, {"5", "6", "7", "8"}, {"9", "10", "11", "12"}, {"9", "10", "11", "12"}});
            System.out.println(result);
        } catch (ArraySizeException | ArrayDataException exception) {
               System.out.println("Валідні дані " + exception.getMessage());
        }

    }
}

