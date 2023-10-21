package controller;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ArquivosController {

    public ArquivosController() {
        super();
    }

    public void AnalisaArquivo(String path, String nome) throws IOException {
        File dir = new File(path);
        File arq = new File(path, nome);

        if (dir.exists() && dir.isDirectory()) {
            if (arq.exists() && arq.isFile()) {
                int cont = 0;
                FileInputStream fluxo = new FileInputStream(arq);
                InputStreamReader leitor = new InputStreamReader(fluxo);
                BufferedReader buffer = new BufferedReader(leitor);


                String linha = buffer.readLine();
                int maxNomeLength = 0; // Variável para armazenar a largura máxima do nome
                int maxSNomeLength = 0; // Variável para armazenar a largura máxima do nome cientifico

                while (linha != null) {
                    if (linha.contains("Fruits")) {
                        String[] fruta = linha.split(",");
                        String nomeFruta = fruta[0];
                        String SnomeFruta = fruta[1];
                        maxNomeLength = Math.max(maxNomeLength, nomeFruta.length());
                        maxSNomeLength = Math.max(maxSNomeLength, SnomeFruta.length());
                    }
                    linha = buffer.readLine();
                }

                // definiar a largura máxima do nome + uma margem para alinhar as colunas
                int nomeColumnWidth = maxNomeLength + 2;
                int SnomeColumnWidth = maxSNomeLength;

                buffer.close();
                leitor.close();
                fluxo.close();

                //----------------------------------------------------------------------------------
                // Agora, imprimir os dados formatados de colunas  
                buffer = new BufferedReader(new InputStreamReader(new FileInputStream(arq)));
                linha = buffer.readLine();

                while (linha != null) {
                    if (linha.contains("Fruits")) {
                        String[] fruta = linha.split(",");
                        String nomeFormatted = String.format("%-" + nomeColumnWidth + "s", fruta[0]);
                        String SnomeFormatted = String.format("%-" + SnomeColumnWidth + "s", fruta[1]);
                        System.out.println(nomeFormatted + "\t" + SnomeFormatted + "\t" + fruta[3]);
                        cont++;
                    }
                    linha = buffer.readLine();
                }

                System.out.println("\nNº de frutas: " + cont);
                buffer.close();
            } else {
                throw new IOException("Arquivo inválido");
            }
        } else {
            throw new IOException("Diretório inválido");
        }
    }
}
