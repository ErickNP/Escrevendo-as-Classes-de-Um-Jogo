package entities;

import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JOptionPane;

public class Heroi {

    private String nome;
    private Integer idade;
    private Integer xp;
    private String classeHeroi;

    private final ArrayList<String> opcoesClasse = new ArrayList<>(Arrays.asList("Mago", "Guerreiro", "Monge", "Ninja"));

    public Heroi() {
    }

    public Heroi(String nome, Integer idade, Integer xp, String classeHeroi) {
        this.nome = nome;
        this.idade = idade;
        this.xp = xp;
        this.classeHeroi = classeHeroi;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public Integer getXp() {
        return xp;
    }

    public void setXp(Integer xp) {
        this.xp = xp;
    }

    public String getClasseHeroi() {
        return classeHeroi;
    }

    public void setClasseHeroi(String classeHeroi) {
        this.classeHeroi = classeHeroi;
    }

    public ArrayList<String> getOpcoesClasse() {
        return opcoesClasse;
    }

    public String posicaoRank(Integer xp) {

        if (xp <= 1000) {

            return "Ferro";

        } else if (xp >= 1001 && xp <= 2000) {

            return "Bronze";

        } else if (xp > 2001 && xp <= 5000) {

            return "Prata";

        } else if (xp > 6001 && xp <= 7000) {

            return "Ouro";

        } else if (xp > 7001 && xp <= 8000) {

            return "Platina";

        } else if (xp > 8001 && xp <= 9000) {

            return "Ascendente";

        } else if (xp > 9001 && xp <= 10000) {

            return "Imortal";

        } else {

            return "Radiante";
        }
    }

    public String atacar() {
        String ataque = "";

        if (classeHeroi.equals("Mago")) {
            ataque = "O Mago " + this.nome + " atacou usando magia";

        } else if (classeHeroi.equals("Guerreiro")) {
            ataque = "O Guerreiro " + this.nome + " atacou usando espada";

        } else if (classeHeroi.equals("Monge")) {
            ataque = "O Monge " + this.nome + " atacou usando artes marciais";

        } else {
            ataque = "O Ninja " + this.nome + " atacou usando shuriken";
        }

        return ataque;
    }

    public String imprimir() {
        return "- O Herói de nome " + this.nome
                + " que pertence a classe " + classeHeroi
                + " está no nível de " + posicaoRank(xp)
                + "\n";

    }

    public void definirCaracteristicas() {
        setNome(JOptionPane.showInputDialog("Informe o nome do Herói"));
        setIdade(Integer.parseInt(JOptionPane.showInputDialog("Digite a idade do herói:")));
        setXp(Integer.parseInt(JOptionPane.showInputDialog("Digite a XP do herói:")));

        ArrayList<String> opcoesClasse = getOpcoesClasse();
        String[] listaDeOpcoes = opcoesClasse.toArray(String[]::new);
        String classeEscolhida = (String) JOptionPane.showInputDialog(null, "Escolha a classe do herói:", "Escolha de Classe", JOptionPane.PLAIN_MESSAGE, null, listaDeOpcoes, listaDeOpcoes[0]);
        setClasseHeroi(classeEscolhida);
    }
}
