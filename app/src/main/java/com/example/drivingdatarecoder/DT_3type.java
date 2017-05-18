package com.example.drivingdatarecoder;

public class DT_3type {
	//各移動モードに対応する番号
	public static final int MODE_OTHER = 0; //=still
	public static final int MODE_WALK = 1;
	public static final int MODE_METRO = 4;

	//コンストラクタ（何もしない）
	public DT_3type(){ }

	//識別メソッド
	public static int classify(float[] i){
		int m=-1;

		Double[] d = new Double[i.length];
		for(int n=0; n<i.length; n++){
			d[n] = new Double(i[n]);
		}

		try {
			m = (int)WekaClassifier1212_all.classify(d);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return m;
	}
}

class WekaClassifier_3type {

	  public static double classify(Object[] i)
	    throws Exception {

	    double p = Double.NaN;
	    p = WekaClassifier_3type.N5f41fff6618(i);
	    return p;
	  }
	  static double N5f41fff6618(Object []i) {
	    double p = Double.NaN;
	    if (i[0] == null) {
	      p = 0;
	    } else if (((Double) i[0]).doubleValue() <= 0.0) {
	    p = WekaClassifier_3type.N32cec521619(i);
	    } else if (((Double) i[0]).doubleValue() > 0.0) {
	    p = WekaClassifier_3type.N16ccce4d623(i);
	    } 
	    return p;
	  }
	  static double N32cec521619(Object []i) {
	    double p = Double.NaN;
	    if (i[1] == null) {
	      p = 0;
	    } else if (((Double) i[1]).doubleValue() <= 0.21647638) {
	      p = 0;
	    } else if (((Double) i[1]).doubleValue() > 0.21647638) {
	    p = WekaClassifier_3type.N6d06af8f620(i);
	    } 
	    return p;
	  }
	  static double N6d06af8f620(Object []i) {
	    double p = Double.NaN;
	    if (i[3] == null) {
	      p = 1;
	    } else if (((Double) i[3]).doubleValue() <= 12.8740225) {
	    p = WekaClassifier_3type.N2010f15621(i);
	    } else if (((Double) i[3]).doubleValue() > 12.8740225) {
	      p = 1;
	    } 
	    return p;
	  }
	  static double N2010f15621(Object []i) {
	    double p = Double.NaN;
	    if (i[1] == null) {
	      p = 0;
	    } else if (((Double) i[1]).doubleValue() <= 0.4248647) {
	    p = WekaClassifier_3type.N526ffeec622(i);
	    } else if (((Double) i[1]).doubleValue() > 0.4248647) {
	      p = 1;
	    } 
	    return p;
	  }
	  static double N526ffeec622(Object []i) {
	    double p = Double.NaN;
	    if (i[4] == null) {
	      p = 1;
	    } else if (((Double) i[4]).doubleValue() <= 3.7350528) {
	      p = 1;
	    } else if (((Double) i[4]).doubleValue() > 3.7350528) {
	      p = 0;
	    } 
	    return p;
	  }
	  static double N16ccce4d623(Object []i) {
	    double p = Double.NaN;
	    if (i[1] == null) {
	      p = 2;
	    } else if (((Double) i[1]).doubleValue() <= 0.14765167) {
	    p = WekaClassifier_3type.N4eee71cc624(i);
	    } else if (((Double) i[1]).doubleValue() > 0.14765167) {
	    p = WekaClassifier_3type.N760b21e0648(i);
	    } 
	    return p;
	  }
	  static double N4eee71cc624(Object []i) {
	    double p = Double.NaN;
	    if (i[0] == null) {
	      p = 2;
	    } else if (((Double) i[0]).doubleValue() <= 1.495929) {
	    p = WekaClassifier_3type.N449db6a3625(i);
	    } else if (((Double) i[0]).doubleValue() > 1.495929) {
	    p = WekaClassifier_3type.N38be3a56637(i);
	    } 
	    return p;
	  }
	  static double N449db6a3625(Object []i) {
	    double p = Double.NaN;
	    if (i[0] == null) {
	      p = 1;
	    } else if (((Double) i[0]).doubleValue() <= 0.1989533) {
	      p = 1;
	    } else if (((Double) i[0]).doubleValue() > 0.1989533) {
	    p = WekaClassifier_3type.N69a8a842626(i);
	    } 
	    return p;
	  }
	  static double N69a8a842626(Object []i) {
	    double p = Double.NaN;
	    if (i[1] == null) {
	      p = 2;
	    } else if (((Double) i[1]).doubleValue() <= 0.10715139) {
	    p = WekaClassifier_3type.N19e6bd9c627(i);
	    } else if (((Double) i[1]).doubleValue() > 0.10715139) {
	    p = WekaClassifier_3type.N286a854b633(i);
	    } 
	    return p;
	  }
	  static double N19e6bd9c627(Object []i) {
	    double p = Double.NaN;
	    if (i[0] == null) {
	      p = 2;
	    } else if (((Double) i[0]).doubleValue() <= 1.2275827) {
	    p = WekaClassifier_3type.N243bdf7d628(i);
	    } else if (((Double) i[0]).doubleValue() > 1.2275827) {
	    p = WekaClassifier_3type.Nd5a5d54631(i);
	    } 
	    return p;
	  }
	  static double N243bdf7d628(Object []i) {
	    double p = Double.NaN;
	    if (i[1] == null) {
	      p = 2;
	    } else if (((Double) i[1]).doubleValue() <= 7.247925E-4) {
	    p = WekaClassifier_3type.Nd3a5df7629(i);
	    } else if (((Double) i[1]).doubleValue() > 7.247925E-4) {
	      p = 2;
	    } 
	    return p;
	  }
	  static double Nd3a5df7629(Object []i) {
	    double p = Double.NaN;
	    if (i[1] == null) {
	      p = 1;
	    } else if (((Double) i[1]).doubleValue() <= 4.4626414E-4) {
	    p = WekaClassifier_3type.N21fc0eaa630(i);
	    } else if (((Double) i[1]).doubleValue() > 4.4626414E-4) {
	      p = 2;
	    } 
	    return p;
	  }
	  static double N21fc0eaa630(Object []i) {
	    double p = Double.NaN;
	    if (i[2] == null) {
	      p = 2;
	    } else if (((Double) i[2]).doubleValue() <= 0.011667744) {
	      p = 2;
	    } else if (((Double) i[2]).doubleValue() > 0.011667744) {
	      p = 1;
	    } 
	    return p;
	  }
	  static double Nd5a5d54631(Object []i) {
	    double p = Double.NaN;
	    if (i[0] == null) {
	      p = 1;
	    } else if (((Double) i[0]).doubleValue() <= 1.25) {
	    p = WekaClassifier_3type.N7760bbb5632(i);
	    } else if (((Double) i[0]).doubleValue() > 1.25) {
	      p = 2;
	    } 
	    return p;
	  }
	  static double N7760bbb5632(Object []i) {
	    double p = Double.NaN;
	    if (i[0] == null) {
	      p = 2;
	    } else if (((Double) i[0]).doubleValue() <= 1.246579) {
	      p = 2;
	    } else if (((Double) i[0]).doubleValue() > 1.246579) {
	      p = 1;
	    } 
	    return p;
	  }
	  static double N286a854b633(Object []i) {
	    double p = Double.NaN;
	    if (i[4] == null) {
	      p = 2;
	    } else if (((Double) i[4]).doubleValue() <= 11.558116) {
	    p = WekaClassifier_3type.N692247b2634(i);
	    } else if (((Double) i[4]).doubleValue() > 11.558116) {
	      p = 1;
	    } 
	    return p;
	  }
	  static double N692247b2634(Object []i) {
	    double p = Double.NaN;
	    if (i[4] == null) {
	      p = 2;
	    } else if (((Double) i[4]).doubleValue() <= 1.7394754) {
	    p = WekaClassifier_3type.N36cd073f635(i);
	    } else if (((Double) i[4]).doubleValue() > 1.7394754) {
	      p = 2;
	    } 
	    return p;
	  }
	  static double N36cd073f635(Object []i) {
	    double p = Double.NaN;
	    if (i[3] == null) {
	      p = 1;
	    } else if (((Double) i[3]).doubleValue() <= 7.090634) {
	      p = 1;
	    } else if (((Double) i[3]).doubleValue() > 7.090634) {
	    p = WekaClassifier_3type.N4402af40636(i);
	    } 
	    return p;
	  }
	  static double N4402af40636(Object []i) {
	    double p = Double.NaN;
	    if (i[0] == null) {
	      p = 1;
	    } else if (((Double) i[0]).doubleValue() <= 0.5211712) {
	      p = 1;
	    } else if (((Double) i[0]).doubleValue() > 0.5211712) {
	      p = 2;
	    } 
	    return p;
	  }
	  static double N38be3a56637(Object []i) {
	    double p = Double.NaN;
	    if (i[0] == null) {
	      p = 1;
	    } else if (((Double) i[0]).doubleValue() <= 2.245981) {
	    p = WekaClassifier_3type.N43dae524638(i);
	    } else if (((Double) i[0]).doubleValue() > 2.245981) {
	    p = WekaClassifier_3type.Nb453365643(i);
	    } 
	    return p;
	  }
	  static double N43dae524638(Object []i) {
	    double p = Double.NaN;
	    if (i[0] == null) {
	      p = 1;
	    } else if (((Double) i[0]).doubleValue() <= 1.5) {
	      p = 1;
	    } else if (((Double) i[0]).doubleValue() > 1.5) {
	    p = WekaClassifier_3type.N1d70f69f639(i);
	    } 
	    return p;
	  }
	  static double N1d70f69f639(Object []i) {
	    double p = Double.NaN;
	    if (i[0] == null) {
	      p = 2;
	    } else if (((Double) i[0]).doubleValue() <= 1.7479951) {
	      p = 2;
	    } else if (((Double) i[0]).doubleValue() > 1.7479951) {
	    p = WekaClassifier_3type.N4c5932de640(i);
	    } 
	    return p;
	  }
	  static double N4c5932de640(Object []i) {
	    double p = Double.NaN;
	    if (i[0] == null) {
	      p = 1;
	    } else if (((Double) i[0]).doubleValue() <= 1.7614094) {
	      p = 1;
	    } else if (((Double) i[0]).doubleValue() > 1.7614094) {
	    p = WekaClassifier_3type.N57ccd89641(i);
	    } 
	    return p;
	  }
	  static double N57ccd89641(Object []i) {
	    double p = Double.NaN;
	    if (i[0] == null) {
	      p = 2;
	    } else if (((Double) i[0]).doubleValue() <= 1.9940726) {
	      p = 2;
	    } else if (((Double) i[0]).doubleValue() > 1.9940726) {
	    p = WekaClassifier_3type.N119bebc7642(i);
	    } 
	    return p;
	  }
	  static double N119bebc7642(Object []i) {
	    double p = Double.NaN;
	    if (i[0] == null) {
	      p = 1;
	    } else if (((Double) i[0]).doubleValue() <= 2.002714) {
	      p = 1;
	    } else if (((Double) i[0]).doubleValue() > 2.002714) {
	      p = 2;
	    } 
	    return p;
	  }
	  static double Nb453365643(Object []i) {
	    double p = Double.NaN;
	    if (i[1] == null) {
	      p = 1;
	    } else if (((Double) i[1]).doubleValue() <= 0.032661438) {
	    p = WekaClassifier_3type.Ne8f2f11644(i);
	    } else if (((Double) i[1]).doubleValue() > 0.032661438) {
	      p = 1;
	    } 
	    return p;
	  }
	  static double Ne8f2f11644(Object []i) {
	    double p = Double.NaN;
	    if (i[0] == null) {
	      p = 1;
	    } else if (((Double) i[0]).doubleValue() <= 2.25) {
	      p = 1;
	    } else if (((Double) i[0]).doubleValue() > 2.25) {
	    p = WekaClassifier_3type.N6dfcabcc645(i);
	    } 
	    return p;
	  }
	  static double N6dfcabcc645(Object []i) {
	    double p = Double.NaN;
	    if (i[4] == null) {
	      p = 2;
	    } else if (((Double) i[4]).doubleValue() <= 2.3661652) {
	    p = WekaClassifier_3type.N2377a067646(i);
	    } else if (((Double) i[4]).doubleValue() > 2.3661652) {
	      p = 1;
	    } 
	    return p;
	  }
	  static double N2377a067646(Object []i) {
	    double p = Double.NaN;
	    if (i[3] == null) {
	      p = 2;
	    } else if (((Double) i[3]).doubleValue() <= 2.0610685) {
	    p = WekaClassifier_3type.N10b7177647(i);
	    } else if (((Double) i[3]).doubleValue() > 2.0610685) {
	      p = 2;
	    } 
	    return p;
	  }
	  static double N10b7177647(Object []i) {
	    double p = Double.NaN;
	    if (i[3] == null) {
	      p = 2;
	    } else if (((Double) i[3]).doubleValue() <= 0.41547358) {
	      p = 2;
	    } else if (((Double) i[3]).doubleValue() > 0.41547358) {
	      p = 1;
	    } 
	    return p;
	  }
	  static double N760b21e0648(Object []i) {
	    double p = Double.NaN;
	    if (i[1] == null) {
	      p = 1;
	    } else if (((Double) i[1]).doubleValue() <= 0.41810608) {
	    p = WekaClassifier_3type.N7ea15626649(i);
	    } else if (((Double) i[1]).doubleValue() > 0.41810608) {
	      p = 1;
	    } 
	    return p;
	  }
	  static double N7ea15626649(Object []i) {
	    double p = Double.NaN;
	    if (i[0] == null) {
	      p = 1;
	    } else if (((Double) i[0]).doubleValue() <= 1.2316403) {
	    p = WekaClassifier_3type.N60cba50d650(i);
	    } else if (((Double) i[0]).doubleValue() > 1.2316403) {
	      p = 1;
	    } 
	    return p;
	  }
	  static double N60cba50d650(Object []i) {
	    double p = Double.NaN;
	    if (i[0] == null) {
	      p = 1;
	    } else if (((Double) i[0]).doubleValue() <= 0.7527456) {
	    p = WekaClassifier_3type.N3a11f0aa651(i);
	    } else if (((Double) i[0]).doubleValue() > 0.7527456) {
	    p = WekaClassifier_3type.N5c008435654(i);
	    } 
	    return p;
	  }
	  static double N3a11f0aa651(Object []i) {
	    double p = Double.NaN;
	    if (i[0] == null) {
	      p = 1;
	    } else if (((Double) i[0]).doubleValue() <= 0.7492301) {
	    p = WekaClassifier_3type.N15bac229652(i);
	    } else if (((Double) i[0]).doubleValue() > 0.7492301) {
	      p = 1;
	    } 
	    return p;
	  }
	  static double N15bac229652(Object []i) {
	    double p = Double.NaN;
	    if (i[0] == null) {
	      p = 1;
	    } else if (((Double) i[0]).doubleValue() <= 0.5036525) {
	      p = 1;
	    } else if (((Double) i[0]).doubleValue() > 0.5036525) {
	    p = WekaClassifier_3type.N615eb6de653(i);
	    } 
	    return p;
	  }
	  static double N615eb6de653(Object []i) {
	    double p = Double.NaN;
	    if (i[3] == null) {
	      p = 2;
	    } else if (((Double) i[3]).doubleValue() <= 50.85143) {
	      p = 2;
	    } else if (((Double) i[3]).doubleValue() > 50.85143) {
	      p = 1;
	    } 
	    return p;
	  }
	  static double N5c008435654(Object []i) {
	    double p = Double.NaN;
	    if (i[4] == null) {
	      p = 2;
	    } else if (((Double) i[4]).doubleValue() <= 17.846012) {
	      p = 2;
	    } else if (((Double) i[4]).doubleValue() > 17.846012) {
	      p = 1;
	    } 
	    return p;
	  }
	}