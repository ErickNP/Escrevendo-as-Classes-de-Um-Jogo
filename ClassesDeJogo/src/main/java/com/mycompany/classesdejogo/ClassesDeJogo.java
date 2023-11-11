package com.mycompany.classesdejogo;

import entities.Heroi;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ClassesDeJogo {

    public static void main(String[] args) {
        List<Heroi> herois = new ArrayList<>();
        String selectedItem = "";

        do {
            Object[] itens = {"Inserir Herói", "Atacar", "Exibir Heróis", "Sair"};
            selectedItem = (String) JOptionPane.showInputDialog(null, "Escolha uma opção:", "Menu", JOptionPane.INFORMATION_MESSAGE, null, itens, itens[0]);

            switch (selectedItem) {

                case "Inserir Herói":

                    Heroi novoHeroi = new Heroi();
                    novoHeroi.definirCaracteristicas();
                    herois.add(novoHeroi);
                    JOptionPane.showMessageDialog(null, "Herói criado com sucesso!");

                    break;

                case "Atacar":
                    
                    if (herois.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Não há heróis para atacar.", "Atenção", JOptionPane.WARNING_MESSAGE);
                        break;
                    }

                    String[] listaHerois = herois.stream().map(Heroi::getNome).toArray(String[]::new);
                    String heroiEscolhido = (String) JOptionPane.showInputDialog(null, "Escolha o Herói:", "Escolha de Herói", JOptionPane.PLAIN_MESSAGE, null, listaHerois, listaHerois[0]);

                    Heroi heroiSelecionado = herois.stream().filter(heroi -> heroi.getNome().equals(heroiEscolhido)).findFirst().orElse(null);

                    if (heroiSelecionado != null) {
                        String mensagemAtaque = heroiSelecionado.atacar();
                        JOptionPane.showMessageDialog(null, mensagemAtaque, "Ataque", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Herói não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
                    }

                    break;

                case "Exibir Heróis":

                    String resultado = "";
                    for (Heroi heroi : herois) {
                        resultado += heroi.imprimir();
                    }

                    JOptionPane.showMessageDialog(null, resultado, "Heróis: ", JOptionPane.INFORMATION_MESSAGE);

                    break;
            }
        } while (!selectedItem.equals("Sair"));
    }
}
