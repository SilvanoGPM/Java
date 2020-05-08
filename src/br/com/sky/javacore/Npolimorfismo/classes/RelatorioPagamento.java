package br.com.sky.javacore.Npolimorfismo.classes;

public class RelatorioPagamento {
    public void relatorioPagamentoGenerio(Funcionario funcionario) {
        System.out.println("Gerando relatorio de pagamento genêrico: ");
        funcionario.calcularPagamento();
        System.out.println("Nome: "+funcionario.getNome());
        System.out.println("Salário: "+funcionario.getSalario());
        if(funcionario instanceof Gerente) {
            System.out.println("Participação nos lucors: "+((Gerente) funcionario).getPnl());
        }
        if(funcionario instanceof Vendedor) {
            System.out.println("Total vendas: "+((Vendedor) funcionario).getTotalVendas());
        }
    }
}
