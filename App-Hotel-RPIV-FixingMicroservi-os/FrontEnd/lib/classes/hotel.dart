class Hotel {
  String nome;
  String dataIn;
  String dataOut;
  String cidade;

  Hotel({this.nome, this.dataIn, this.dataOut, this.cidade});

  Hotel.fromJson(Map<String, dynamic> json) {
    nome = json['nome'];
    dataIn = json['dataIn'];
    dataOut = json['dataOut'];
    cidade = json['Cidade'];
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = new Map<String, dynamic>();
    data['nome'] = this.nome;
    data['dataIn'] = this.dataIn;
    data['dataOut'] = this.dataOut;
    data['Cidade'] = this.cidade;
    return data;
  }
}