package funcoes;

public class CalculoMedidas {
	public double calculos(double valorDigitado, String opcao1Selecionada, String opcao2Selecionada, String[] opcoes) {

        // Base Metro

        // Metro para metro
        if (opcao1Selecionada.equals(opcoes[0]) && opcao2Selecionada.equals(opcoes[0])) {
            return valorDigitado;
        }
        // Metro para dm
        if (opcao1Selecionada.equals(opcoes[0]) && opcao2Selecionada.equals(opcoes[1])) {
            return valorDigitado * 10;
        }
        // Metro para cm
        if (opcao1Selecionada.equals(opcoes[0]) && opcao2Selecionada.equals(opcoes[2])) {
            return valorDigitado * 100;
        }
        // Metro para mm
        if (opcao1Selecionada.equals(opcoes[0]) && opcao2Selecionada.equals(opcoes[3])) {
            return valorDigitado * 1000;
        }

        // Base dm

        // dm para metro 
        if (opcao1Selecionada.equals(opcoes[1]) && opcao2Selecionada.equals(opcoes[0])) {
            return valorDigitado / 10;
        }
        // dm para dm
        if (opcao1Selecionada.equals(opcoes[1]) && opcao2Selecionada.equals(opcoes[1])) {
            return valorDigitado;
        }
        // dm para cm
        if (opcao1Selecionada.equals(opcoes[1]) && opcao2Selecionada.equals(opcoes[2])) {
            return valorDigitado * 10;
        }
        // dm para mm
        if (opcao1Selecionada.equals(opcoes[1]) && opcao2Selecionada.equals(opcoes[3])) {
            return valorDigitado * 100;
        }

        // Base cm

        // cm para metro
        if (opcao1Selecionada.equals(opcoes[2]) && opcao2Selecionada.equals(opcoes[0])) {
            return valorDigitado / 100;
        }
        // cm para dm
        if (opcao1Selecionada.equals(opcoes[2]) && opcao2Selecionada.equals(opcoes[1])) {
            return valorDigitado / 10;
        }
        // cm para cm
        if (opcao1Selecionada.equals(opcoes[2]) && opcao2Selecionada.equals(opcoes[2])) {
            return valorDigitado;
        }
        // cm para mm
        if (opcao1Selecionada.equals(opcoes[2]) && opcao2Selecionada.equals(opcoes[3])) {
            return valorDigitado * 10;
        }

        // Base mm

        // mm para metro
        if (opcao1Selecionada.equals(opcoes[3]) && opcao2Selecionada.equals(opcoes[0])) {
            return valorDigitado / 1000;
        }
        // mm para dm
        if (opcao1Selecionada.equals(opcoes[3]) && opcao2Selecionada.equals(opcoes[1])) {
            return valorDigitado / 100;

        }
        // mm para cm
        if (opcao1Selecionada.equals(opcoes[3]) && opcao2Selecionada.equals(opcoes[2])) {
            return valorDigitado / 10;
        }
        // mm para mm
        if (opcao1Selecionada.equals(opcoes[3]) && opcao2Selecionada.equals(opcoes[3])) {
            return valorDigitado;
        }

        throw new RuntimeException("Erro inesperado - Nenhuma condição atendida.");

    }
}
