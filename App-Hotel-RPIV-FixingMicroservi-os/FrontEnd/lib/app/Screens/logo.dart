import 'package:app_hotel/app/Screens/Components/icons.dart';
import 'package:flutter/material.dart';
import 'package:flutter_svg/flutter_svg.dart';

class Logo extends StatelessWidget {
  const Logo({
    Key key,
  }) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Container(
      margin: const EdgeInsets.only(top: 100),
      child: SvgPicture.asset(
        tela_login,
        width: double.maxFinite,
        height: 100,
        fit: BoxFit.contain,
        alignment: Alignment.topCenter,
      ),
    );
  }
}
