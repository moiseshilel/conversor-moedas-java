package funcoes;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import sistema.Conversores;
import sistema.Navegacao;

public class Medidas implements Conversores {

    @Override
    public void conversor() {

        double valorDigitado;
        String opcao1Selecionada;
        String opcao2Selecionada;
        int botaoPressionado;
        double resultado = 0;

        final String[] OPCOES = { "M", "dm", "cm", "mm" };

        JPanel quadro = new JPanel();
        JLabel txt1 = new JLabel("Converter ");
        JTextField valor = new JTextField(3);
        JLabel txt2 = new JLabel(" para ");
        JComboBox<String> opcoesLista1 = new JComboBox<String>(OPCOES);
        JComboBox<String> opcoesLista2 = new JComboBox<String>(OPCOES);
        JLabel txt3 = new JLabel(
                "<html><body width='%1s'><p>M - Metro<br>dm - Decímetro<br>cm - Centímetro<br>mm - Milímetros</p>");

        quadro.add(txt1);
        quadro.add(valor);
        quadro.add(opcoesLista1);
        quadro.add(txt2);
        quadro.add(opcoesLista2);
        quadro.add(txt3);

        while (true) {


            while (true) {
                botaoPressionado = JOptionPane.showOptionDialog(null, quadro, Navegacao.TITULO, JOptionPane.NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE, null, Navegacao.CONVERT, null);
                
                if (botaoPressionado == 0) { 

                    try {
                        valorDigitado = Double.valueOf(valor.getText());
                        opcao1Selecionada = (String) opcoesLista1.getSelectedItem();
                        opcao2Selecionada = (String) opcoesLista2.getSelectedItem();
                        break;
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, Navegacao.ERROR_MSG, Navegacao.TITULO, 0);
                        valor.setText("");
                    }
                
                } else { 
                    throw new RuntimeException("Conversor finalizado.");
                }
            }

            CalculoMedidas vcalc = new CalculoMedidas();
            resultado = vcalc.calculos(valorDigitado, opcao1Selecionada, opcao2Selecionada, OPCOES);

            String resultadoFinal = (valorDigitado) + " " + opcao1Selecionada + " é igual a "
                    + (resultado) + " " + opcao2Selecionada + ".";
            JOptionPane.showMessageDialog(null, resultadoFinal, Navegacao.TITULO, -1);

            botaoPressionado = JOptionPane.showOptionDialog(null, "Deseja fazer outra conversão?", Navegacao.TITULO, 0, 3,
                    null, Navegacao.YES_NO, null);

            if (botaoPressionado != 0) { // Sair
                break;
            } else {
                valor.setText("");
                opcoesLista1.setSelectedItem(OPCOES[0]);
                opcoesLista2.setSelectedItem(OPCOES[0]);
            }
        }
    }
}