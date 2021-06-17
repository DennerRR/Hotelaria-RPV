//import 'package:http/http.dart' as http;
import 'package:app_hotel/app/Screens/textInputField.dart';
import 'package:flutter/gestures.dart';
import 'package:flutter/material.dart';
import 'package:font_awesome_flutter/font_awesome_flutter.dart';
//import 'package:url_launcher/url_launcher.dart';

class LoginForm extends StatefulWidget {
  const LoginForm({
    Key key,
  }) : super(key: key);

  @override
  _LoginFormState createState() => _LoginFormState();
}

// Future<Map> fetch() async {
//   var url = 'http://localhost:8761/users/todos';
//   var response = await http.get(url);
//   var json = jsonDecode(response.body);
//   var todo = Todo.fromJson(json);
//   return json;
// }

// class Todo {
//   int id;
//   String email;
//   String nome;
//   String cargo;
//   String cpf;
//   String telefone;
//   String senha;

//   Todo(
//       {this.id,
//       this.email,
//       this.nome,
//       this.cargo,
//       this.cpf,
//       this.telefone,
//       this.senha});

//   Todo.fromJson(Map<String, dynamic> json) {
//     id = json['id'];
//     email = json['email'];
//     nome = json['nome'];
//     cargo = json['cargo'];
//     cpf = json['cpf'];
//     telefone = json['telefone'];
//     senha = json['senha'];
//   }

//   Map<String, dynamic> toJson() {
//     final Map<String, dynamic> data = new Map<String, dynamic>();
//     data['id'] = this.id;
//     data['email'] = this.email;
//     data['nome'] = this.nome;
//     data['cargo'] = this.cargo;
//     data['cpf'] = this.cpf;
//     data['telefone'] = this.telefone;
//     data['senha'] = this.senha;
//     return data;
//   }
// }

class _LoginFormState extends State<LoginForm> {
  final String email = 'ecs@gmail.com';

  final String password = '123';

  @override
  Widget build(BuildContext context) {
    return Container(
      child: SingleChildScrollView(
        child: SizedBox(
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.stretch,
            children: [
              TextInputField(
                  icon: FontAwesomeIcons.envelope,
                  text: 'Email',
                  inputType: TextInputType.emailAddress,
                  inputAction: TextInputAction.next),
              SizedBox(height: 5),
              TextInputField(
                  icon: FontAwesomeIcons.lock,
                  text: 'Senha',
                  inputType: TextInputType.name,
                  inputAction: TextInputAction.done),
              SizedBox(height: 10),
              TextButton(
                onPressed: () {
                  if (email == 'ecs@gmail.com' && password == '123') {
                    Navigator.of(context).pushReplacementNamed('/reservas');
                  } else {
                    print('Login inválido');
                  }
                },
                style: ButtonStyle(
                  backgroundColor: MaterialStateProperty.all(Colors.white),
                ),
                child: Text(
                  'Entrar',
                  textAlign: TextAlign.center,
                ),
              ),
              SizedBox(height: 10),
              RichText(
                text: TextSpan(
                    text: "Esqueci minha senha",
                    style: TextStyle(
                        decoration: TextDecoration.underline,
                        color: Colors.white,
                        fontWeight: FontWeight.bold,
                        fontSize: 12),
                    recognizer: TapGestureRecognizer()
                      ..onTap = () async {
                        Navigator.of(context).pushNamed('/recuperarSenha');
                      }),
              ),
              SizedBox(height: 50),
              Row(
                mainAxisAlignment: MainAxisAlignment.center,
                children: [
                  RichText(
                    text: TextSpan(
                      children: [
                        TextSpan(
                          text: "Novo por aqui? ",
                          style: TextStyle(
                            color: Colors.white,
                            fontWeight: FontWeight.bold,
                            fontSize: 14,
                          ),
                        ),
                        TextSpan(
                            text: "Crie sua conta",
                            style: TextStyle(
                                decoration: TextDecoration.underline,
                                color: Colors.white,
                                fontWeight: FontWeight.bold,
                                fontSize: 14),
                            recognizer: TapGestureRecognizer()
                              ..onTap = () async {
                                Navigator.of(context)
                                    .pushNamed('/criarCadastro');
                              }),
                      ],
                    ),
                  ),
                ],
              ),
            ],
          ),
        ),
      ),
      alignment: Alignment.center,
    );
  }
}
