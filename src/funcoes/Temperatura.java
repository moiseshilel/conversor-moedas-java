package funcoes;

import java.text.DecimalFormat;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import sistema.Conversores;
import sistema.Navegacao;

public class Temperatura implements Conversores {

    @Override
    public void conversor() {

        double valorDigitado;
        String opcao1Selecionada;
        String opcao2Selecionada;
        int botaoPressionado;
        double resultado = 0;

        DecimalFormat formato = new DecimalFormat("##.00");

        final String[] OPCOES = { "Celsius", "Fahrenheit", "Kelvin" };

        JPanel quadro = new JPanel();
        JLabel txt1 = new JLabel("Converter ");
        JTextField valor = new JTextField(3);
        JLabel txt2 = new JLabel(" para ");
        JComboBox<String> opcoesLista1 = new JComboBox<String>(OPCOES);
        JComboBox<String> opcoesLista2 = new JComboBox<String>(OPCOES);

        quadro.add(txt1);
        quadro.add(valor);
        quadro.add(opcoesLista1);
        quadro.add(txt2);
        quadro.add(opcoesLista2);

        while (true) {

            while (true) {
                botaoPressionado = JOptionPane.showOptionDialog(null, quadro, Navegacao.TITULO, JOptionPane.NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE, null, Navegacao.BOTAO, null);

                if (botaoPressionado == 0) {

                    try {
                        valorDigitado = Double.valueOf(valor.getText());
                        opcao1Selecionada = (String) opcoesLista1.getSelectedItem();
                        opcao2Selecionada = (String) opcoesLista2.getSelectedItem();
                        break;
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, Navegacao.AVISO_MENSAGEM, Navegacao.TITULO, 0);
                        valor.setText("");
                    }

                } else {
                    throw new RuntimeException("Função encerrada.");
                }
            }

           

            TempCalculos tcalc = new TempCalculos();
            resultado = tcalc.calculos(valorDigitado, opcao1Selecionada, opcao2Selecionada, OPCOES);

         

            String resultadoFinal = formato.format(valorDigitado) + " " + opcao1Selecionada + " é igual a "
                    + formato.format(resultado) + " " + opcao2Selecionada + ".";
            JOptionPane.showMessageDialog(null, resultadoFinal, Navegacao.TITULO, -1);

        

            botaoPressionado = JOptionPane.showOptionDialog(null, "Deseja fazer outra conversão?", Navegacao.TITULO, 0, 3,
                    null, Navegacao.BOTOES_CONFIRMACAO, null);

            if (botaoPressionado != 0) { 
                break;
            } else { 
                valor.setText("");
                opcoesLista1.setSelectedItem(OPCOES[0]);
                opcoesLista2.setSelectedItem(OPCOES[0]);
            }
        }
    }
}
