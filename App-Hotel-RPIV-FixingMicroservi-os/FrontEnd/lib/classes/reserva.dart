class Reserva {
  String dataIn = ' ';
  String dataOut = ' ';
  String cidade = ' ';

  Reserva({this.dataIn, this.dataOut, this.cidade});

  Reserva.fromJson(Map<String, dynamic> json) {
    dataIn = json['dataIn'];
    dataOut = json['dataOut'];
    cidade = json['Cidade'];
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = new Map<String, dynamic>();
    data['dataIn'] = this.dataIn;
    data['dataOut'] = this.dataOut;
    data['Cidade'] = this.cidade;
    return data;
  }
}