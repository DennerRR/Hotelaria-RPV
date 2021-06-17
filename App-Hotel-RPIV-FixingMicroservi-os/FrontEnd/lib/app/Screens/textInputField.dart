import 'package:flutter/foundation.dart';
import 'package:flutter/material.dart';

class TextInputField extends StatelessWidget {
  const TextInputField({
    Key key,
    this.icon,
    this.text,
    this.inputType,
    this.inputAction,
  }) : super(key: key);

  final IconData icon;
  final String text;
  final TextInputType inputType;
  final TextInputAction inputAction;

  bool isPassword(String text) {
    if (text == 'Senha') {
      return true;
    } else {
      return false;
    }
  }

  @override
  Widget build(BuildContext context) {
    Size size = MediaQuery.of(context).size;

    return Padding(
      padding: const EdgeInsets.symmetric(vertical: 10.0),
      child: Container(
        height: size.height * 0.08,
        width: size.width * 0.8,
        decoration: BoxDecoration(
          color: Colors.grey[500].withOpacity(0.5),
          borderRadius: BorderRadius.circular(16),
        ),
        child: Center(
          child: TextFormField(
            style: TextStyle(color: Colors.white),
            decoration: InputDecoration(
              isDense: true,
              prefixIcon: Padding(
                padding: const EdgeInsets.symmetric(horizontal: 20.0),
                child: Icon(
                  icon,
                  size: 15,
                  color: Colors.white,
                ),
              ),
              hintText: text,
              hintStyle: TextStyle(color: Colors.white),
              enabledBorder: OutlineInputBorder(
                borderSide: BorderSide(color: Colors.white),
                borderRadius: BorderRadius.circular(10),
              ),
              focusedBorder: OutlineInputBorder(
                borderSide: BorderSide(color: Colors.red),
                borderRadius: BorderRadius.circular(10),
              ),
            ),
            obscureText: isPassword(text),
            keyboardType: inputType,
            textInputAction: inputAction,
            cursorColor: Colors.blue,
            validator: (String value) {
              if (value.isEmpty || value == null) {
                return 'Por favor digite $text';
              }
              if (text == 'Email' &&
                  !RegExp("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+.[a-z]")
                      .hasMatch(value)) {
                return 'Digite $text válido!';
              }
              return null;
            },
          ),
        ),
      ),
    );
  }
}
