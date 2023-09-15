import java.util.Scanner;

public class MegaSenaAposta {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double fatn=1, fatp=1, x=50063860, fatn_p=1, n_p, c1, errar60, fatErrar60=1,
        errar6, fatErrar6=1, resto, fatResto=1, c2, c3, valor=4.5, aposta, fat6=1, n_6,
        fatn_6=1, valorPago;

        System.out.println("Algorítmo que calcula a probabilidade de ganhar na Mega Sena.");

        System.out.print("Quantos números irá apostar? ");
        int n = sc.nextInt();
        System.out.print("Quantos acertos terá no sorteio de 6 números?");
        int p = sc.nextInt();

        if(n<0 || p>6){
            System.out.println("Entre com dados válidos.");
        } else{
            //Cálculo da probabilidade de acertar n números.
        for(int i=1;i<=n;i++){
            fatn*=i;
        }

        for(int i=1;i<=p;i++){
            fatp*=i;
        }

        n_p = n-p;
        for(int i=1;i<=n_p;i++){
            fatn_p*=i;
        }

        c1 = fatn/(fatp*fatn_p);
        
        //Cálculo da probabilidade de errar n-p números.
        errar60 = 60-n;
        for(int i=1;i<=errar60;i++){
            fatErrar60*=i;
        }

        errar6 = 6-p;
        for(int i=1;i<=errar6;i++){
            fatErrar6*=i;
        }

        resto = errar60-errar6;
        for(int i=1;i<=resto;i++){
            fatResto*=i;
        }

        // Cálculo da probabilidade final
        c2 = fatErrar60/(fatErrar6*fatResto);

        c3 = x/(c1*c2);

        // Cálculo do valor pago na aposta de p números
        for(int i=1;i<=6;i++){
            fat6*=i;
        }
        
        n_6 = n-6;   
        for(int i=1;i<=n_6;i++){
            fatn_6*=i;
        }
        
        aposta = fatn/(fat6*fatn_6); // calcula a quantidade de jogos que foram feitas

        valorPago = valor*aposta;

        System.out.printf("A probabilidade de acertar %d e errar %.0f números é de 1 jogo a cada %.2f jogos.\n", p, errar6, c3);
        System.out.printf("Considerando que o valor de uma aposta é R$: %.2f reais, com %d números, o valor total da aposta foi de R$: %.2f reais, que equivale a %.0f jogos.", valor, n, valorPago, aposta);
        }


        sc.close();
    }
}
