public class TorreDeHanoi {

    public static int moverDiscos(int n, int origem, int destino, int auxiliar) {
        int movimentos = 0;
        if (n == 1) {
            System.out.println("Mova o disco 1 do pino " + origem + " para o pino " + destino);
            movimentos++;
        } else {
            movimentos += moverDiscos(n - 1, origem, auxiliar, destino);
            System.out.println("Mova o disco " + n + " do pino " + origem + " para o pino " + destino);
            movimentos++;
            movimentos += moverDiscos(n - 1, auxiliar, destino, origem);
        }
        return movimentos;
    }

    public static void main(String[] args) {
        int n = 30; // número de discos
        int origem = 1; // pino de origem
        int destino = 3; // pino de destino
        int auxiliar = 2; // pino auxiliar

        long inicio = System.nanoTime(); // tempo de início
        int movimentos = moverDiscos(n, origem, destino, auxiliar);
        long fim = System.nanoTime(); // tempo de fim

        long duracao = fim - inicio; // tempo de duração em nanossegundos

        // Converter a duração para o formato HH:MM:SS:mm
        long horas = duracao / 3600000000000L;
        long minutos = (duracao / 60000000000L) % 60;
        long segundos = (duracao / 1000000000L) % 60;
        long milissegundos = (duracao / 1000000L) % 1000;
        String tempo = String.format("%02d:%02d:%02d:%03d", horas, minutos, segundos, milissegundos);

        System.out.println("Tempo gasto: " + tempo);
        System.out.println("Movimentos realizados: " + movimentos);
    }
}