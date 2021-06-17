import 'package:flutter/material.dart';

class BackgroundImage extends StatelessWidget {
  final Widget child;

  const BackgroundImage({
    Key key,
    this.child,
  }) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Container(
      decoration: BoxDecoration(
        gradient: LinearGradient(
          begin: Alignment.topCenter,
          end: Alignment.bottomCenter,
          colors: [
            Colors.blue,
            Colors.blue[900],
            Colors.blueGrey,
          ],
        ),
      ),
      child: child,
    );
  }
}
