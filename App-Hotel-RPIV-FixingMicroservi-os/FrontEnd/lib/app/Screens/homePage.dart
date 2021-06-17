import 'package:app_hotel/app/Screens/backgroundImage.dart';
import 'package:app_hotel/app/Screens/loginForm.dart';
import 'package:app_hotel/app/Screens/logo.dart';
import 'package:flutter/material.dart';

class HomePage extends StatefulWidget {
  HomePage({Key key}) : super(key: key);

  @override
  _HomePageState createState() => _HomePageState();
}

class _HomePageState extends State<HomePage> {
  @override
  Widget build(BuildContext context) {
    return BackgroundImage(
      child: Scaffold(
        backgroundColor: Colors.transparent,
        body: SingleChildScrollView(
          child: Padding(
            padding: const EdgeInsets.symmetric(horizontal: 20),
            child: Column(
              children: [
                Logo(),
                LoginForm(),
              ],
            ),
          ),
        ),
      ),
    );
  }
}
