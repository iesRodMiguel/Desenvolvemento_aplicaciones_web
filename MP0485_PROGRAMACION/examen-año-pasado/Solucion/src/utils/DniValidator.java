package utils;

public class DniValidator extends Validator {

    // Táboa de letras de control segundo o resto da división entre 23.
    private static final String LETTERS = "TRWAGMYFPDXBNJZSQVHLCKE";

    @Override
    public boolean isValid(Object data) {
        try {
            if (!(data instanceof String)) {
                return false;
            }
            String dni = (String) data;

            // Comproba se o formato é correcto: 8 díxitos seguidos dunha letra.
            if (!dni.matches("\\d{8}[A-Z]")) return false;

            // Separa os díxitos e a letra.
            String numberPart = dni.substring(0, 8);
            char letterPart = dni.charAt(8);

            // Calcula a letra correspondente.
            int number = Integer.parseInt(numberPart);
            char expectedLetter = LETTERS.charAt(number % 23);

            // Compara a letra do DNI coa calculada.
            return letterPart == expectedLetter;
        } catch(NumberFormatException e) {}
        return false;
    }

    @Override
    public String message() {
        return "O DNI non é válido.";
    }
}

