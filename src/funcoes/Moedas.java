package funcoes;


import java.text.DecimalFormat;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import sistema.Conversores;
import sistema.EnumMoedas;
import sistema.Navegacao;

public class Moedas implements Conversores {

    @Override
    public void conversor() {

        double valorDigitado;
        String opcao1Selecionada;
        String opcao1SelecionadaSigla = "";
        String opcao2Selecionada;
        String opcao2SelecionadaSigla = "";
        int botaoPressionado;
        double resultado = 0;

        DecimalFormat formato = new DecimalFormat("##.00");

        EnumMoedas[] moedasLista = EnumMoedas.values();
        String[] opcoes = new String[moedasLista.length];
        for (int i = 0; i < moedasLista.length; i++) {
            opcoes[i] = moedasLista[i].getNome();
        }

        JPanel quadro = new JPanel();
        JLabel txt1 = new JLabel("Converter ");
        JTextField valor = new JTextField(3);
        JLabel txt2 = new JLabel(" para ");
        JComboBox<String> opcoesLista1 = new JComboBox<String>(opcoes);
        JComboBox<String> opcoesLista2 = new JComboBox<String>(opcoes);


        quadro.add(txt1);
        quadro.add(valor);
        quadro.add(opcoesLista1);
        quadro.add(txt2);
        quadro.add(opcoesLista2);

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


            for (EnumMoedas moedas : moedasLista) {
                if (moedas.getNome().equals(opcao1Selecionada)) {
                    opcao1SelecionadaSigla = moedas.getSigla();
                }
                if (moedas.getNome().equals(opcao2Selecionada)) {
                    opcao2SelecionadaSigla = moedas.getSigla();
                }
            }


            MoedaCalculos mcalc = new MoedaCalculos();
            resultado = mcalc.calculos(valorDigitado, opcao1SelecionadaSigla, opcao2SelecionadaSigla, opcoes);

            String resultadoFinal = opcao1SelecionadaSigla + " " + formato.format(valorDigitado) + " é igual a "
                    + opcao2SelecionadaSigla + " " + formato.format(resultado) + ".";
            JOptionPane.showMessageDialog(null, resultadoFinal, Navegacao.TITULO, -1);


            botaoPressionado = JOptionPane.showOptionDialog(null, "Deseja fazer outra conversão?", Navegacao.TITULO, 0, 3,
                    null, Navegacao.YES_NO, null);

            if (botaoPressionado != 0) {
                break;
            } else {
                valor.setText("");
                opcoesLista1.setSelectedItem(opcoes[0]);
                opcoesLista2.setSelectedItem(opcoes[0]);
            }
        }
    }
}