import javax.swing.JOptionPane;

import funcoes.Medidas;
import funcoes.Moedas;
import funcoes.Temperatura;
import sistema.EnumMenuPrincipal;
import sistema.Navegacao;


public class Aplicativo {


	public static void main(String[] args) {
		
		final String MSG = "<html><body width='%1s'><h1>Escolha o conversor que deseja utilizar: </h1>";
		final String MSG_FINAL = 
							"<html><body width='%1s'><h2>Programa Finalizado!</h2>"
					        + "Este foi mais um desafio proposto por: <br>" 
					        + "Alura + ONE (Oracle Next Education) <br>"
					        + "Turma T5 Back-end <br>"
					        + "Desenvolvido por: <br>"
					        + "Moisés G S Hilel<br>"
					        + "Obrigado.";
		boolean fechar = false;
		
		EnumMenuPrincipal[] menuPrincipal = EnumMenuPrincipal.values();
        String[] menuPrincipalOpcoes = new String[menuPrincipal.length];
        for (int i = 0; i < menuPrincipal.length; i++) {
            menuPrincipalOpcoes[i] = menuPrincipal[i].getDescricao();
       }
  
        while (!fechar) {
            
            String opcaoSelecionada = "";
            opcaoSelecionada += JOptionPane.showOptionDialog(null, MSG, Navegacao.TITULO, 0, -1, null, menuPrincipalOpcoes,
                    null);
   
            
            switch (opcaoSelecionada) {
            case "0": // Moedas
                Moedas moeda = new Moedas();
                try {
                    moeda.conversor();
                } catch (RuntimeException e) {
                    System.out.println(e.getMessage());
                }
                break;

            case "1": // Temperatura
                Temperatura temperatura = new Temperatura();
                try {
                    temperatura.conversor();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;

            case "2": // Medidas
                Medidas medidas = new Medidas();
                try {
                    medidas.conversor();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;

            case "-1", "3":
                fechar = true;
                break;

            default:
                break;
            }     
        }
        JOptionPane.showMessageDialog(null, MSG_FINAL, Navegacao.TITULO, -1);

    }

}