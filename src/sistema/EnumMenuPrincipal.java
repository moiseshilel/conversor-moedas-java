package sistema;

public enum EnumMenuPrincipal {

		MOEDAS(0, "Conversor de Moedas"),
		TEMPERATURAS(1, "Conversor de Temperaturas"),
		MEDIDAS(2, "Conversor de Medidas"),
		FECHAR(3, "Fechar");
		
		private final int id;
		private final String descricao;
		
		EnumMenuPrincipal(int id, String descricao) {
			this.id = id;
			this.descricao = descricao;
		}
		
		public int getId() {
			return this.id;
		}
		
		public String getDescricao() {
			return this.descricao;
		}
}
