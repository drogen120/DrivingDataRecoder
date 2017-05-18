package com.example.drivingdatarecoder;

public class DTped0827 {
	//各移動モードに対応する番号
	public static final int MODE_OTHER = 0; //=still
	public static final int MODE_WALK = 1;
	public static final int MODE_RUN = 2;

	//コンストラクタ（何もしない）
	public DTped0827(){}

	//識別メソッド
	public static int classify(float[] i){
		int m=-1;

		Double[] d;
		int n;
		//速度データが欠損または0のとき
		if(i[0] < 0.0000001f){
			d = new Double[i.length-1];
			for(n=0; n<d.length; n++){
				d[n] = new Double(i[n+1]);
			}
			try{
				m = (int)WekaClassifier0827Accel.classify(d);
			}catch (Exception e){
				e.printStackTrace();
			}


		//正の値の速度データがある時
		}else{
			d = new Double[i.length];
			for(n=0; n<d.length; n++){
				d[n] = new Double(i[n]);
			}
			try{
				m = (int)WekaClassifier0827.classify(d);
			}catch (Exception e){
				e.printStackTrace();
			}
		}

		return m;
	}
}

//加速度の特徴量だけ用いる場合の識別メソッド
//（WekaのJ48にて自動生成）
class WekaClassifier0827Accel {

	  public static double classify(Object[] i)
	    throws Exception {

	    double p = Double.NaN;
	    p = WekaClassifier0827Accel.N90c8bbb86(i);
	    return p;
	  }
	  static double N90c8bbb86(Object []i) {
	    double p = Double.NaN;
	    if (i[0] == null) {
	      p = 1;
	    } else if (((Double) i[0]).doubleValue() <= 33.283432) {
	    p = WekaClassifier0827Accel.N16a9a6a187(i);
	    } else if (((Double) i[0]).doubleValue() > 33.283432) {
	    p = WekaClassifier0827Accel.N302f3a2e132(i);
	    }
	    return p;
	  }
	  static double N16a9a6a187(Object []i) {
	    double p = Double.NaN;
	    if (i[0] == null) {
	      p = 0;
	    } else if (((Double) i[0]).doubleValue() <= 2.2482414) {
	    p = WekaClassifier0827Accel.N5bfa9fa688(i);
	    } else if (((Double) i[0]).doubleValue() > 2.2482414) {
	    p = WekaClassifier0827Accel.N7d27a2b692(i);
	    }
	    return p;
	  }
	  static double N5bfa9fa688(Object []i) {
	    double p = Double.NaN;
	    if (i[2] == null) {
	      p = 0;
	    } else if (((Double) i[2]).doubleValue() <= 53.107822) {
	      p = 0;
	    } else if (((Double) i[2]).doubleValue() > 53.107822) {
	    p = WekaClassifier0827Accel.N23077a7789(i);
	    }
	    return p;
	  }
	  static double N23077a7789(Object []i) {
	    double p = Double.NaN;
	    if (i[2] == null) {
	      p = 0;
	    } else if (((Double) i[2]).doubleValue() <= 170.68503) {
	    p = WekaClassifier0827Accel.N3ff92c9890(i);
	    } else if (((Double) i[2]).doubleValue() > 170.68503) {
	      p = 1;
	    }
	    return p;
	  }
	  static double N3ff92c9890(Object []i) {
	    double p = Double.NaN;
	    if (i[1] == null) {
	      p = 0;
	    } else if (((Double) i[1]).doubleValue() <= 37.185005) {
	      p = 0;
	    } else if (((Double) i[1]).doubleValue() > 37.185005) {
	    p = WekaClassifier0827Accel.N7fdecff791(i);
	    }
	    return p;
	  }
	  static double N7fdecff791(Object []i) {
	    double p = Double.NaN;
	    if (i[1] == null) {
	      p = 1;
	    } else if (((Double) i[1]).doubleValue() <= 40.952526) {
	      p = 1;
	    } else if (((Double) i[1]).doubleValue() > 40.952526) {
	      p = 0;
	    }
	    return p;
	  }
	  static double N7d27a2b692(Object []i) {
	    double p = Double.NaN;
	    if (i[0] == null) {
	      p = 1;
	    } else if (((Double) i[0]).doubleValue() <= 22.85349) {
	    p = WekaClassifier0827Accel.N352b9aeb93(i);
	    } else if (((Double) i[0]).doubleValue() > 22.85349) {
	    p = WekaClassifier0827Accel.N48b98610109(i);
	    }
	    return p;
	  }
	  static double N352b9aeb93(Object []i) {
	    double p = Double.NaN;
	    if (i[2] == null) {
	      p = 1;
	    } else if (((Double) i[2]).doubleValue() <= 347.33914) {
	    p = WekaClassifier0827Accel.N41c7d59294(i);
	    } else if (((Double) i[2]).doubleValue() > 347.33914) {
	    p = WekaClassifier0827Accel.N557597b7104(i);
	    }
	    return p;
	  }
	  static double N41c7d59294(Object []i) {
	    double p = Double.NaN;
	    if (i[3] == null) {
	      p = 1;
	    } else if (((Double) i[3]).doubleValue() <= 1029.5022) {
	    p = WekaClassifier0827Accel.N269685fb95(i);
	    } else if (((Double) i[3]).doubleValue() > 1029.5022) {
	    p = WekaClassifier0827Accel.N17d06a95100(i);
	    }
	    return p;
	  }
	  static double N269685fb95(Object []i) {
	    double p = Double.NaN;
	    if (i[0] == null) {
	      p = 1;
	    } else if (((Double) i[0]).doubleValue() <= 17.539902) {
	    p = WekaClassifier0827Accel.N6436358796(i);
	    } else if (((Double) i[0]).doubleValue() > 17.539902) {
	    p = WekaClassifier0827Accel.Nd23886899(i);
	    }
	    return p;
	  }
	  static double N6436358796(Object []i) {
	    double p = Double.NaN;
	    if (i[2] == null) {
	      p = 0;
	    } else if (((Double) i[2]).doubleValue() <= 43.79902) {
	      p = 0;
	    } else if (((Double) i[2]).doubleValue() > 43.79902) {
	    p = WekaClassifier0827Accel.N22f4657797(i);
	    }
	    return p;
	  }
	  static double N22f4657797(Object []i) {
	    double p = Double.NaN;
	    if (i[0] == null) {
	      p = 1;
	    } else if (((Double) i[0]).doubleValue() <= 15.014137) {
	      p = 1;
	    } else if (((Double) i[0]).doubleValue() > 15.014137) {
	    p = WekaClassifier0827Accel.N5b31798e98(i);
	    }
	    return p;
	  }
	  static double N5b31798e98(Object []i) {
	    double p = Double.NaN;
	    if (i[1] == null) {
	      p = 2;
	    } else if (((Double) i[1]).doubleValue() <= 530.5291) {
	      p = 2;
	    } else if (((Double) i[1]).doubleValue() > 530.5291) {
	      p = 1;
	    }
	    return p;
	  }
	  static double Nd23886899(Object []i) {
	    double p = Double.NaN;
	    if (i[1] == null) {
	      p = 2;
	    } else if (((Double) i[1]).doubleValue() <= 696.8724) {
	      p = 2;
	    } else if (((Double) i[1]).doubleValue() > 696.8724) {
	      p = 1;
	    }
	    return p;
	  }
	  static double N17d06a95100(Object []i) {
	    double p = Double.NaN;
	    if (i[0] == null) {
	      p = 1;
	    } else if (((Double) i[0]).doubleValue() <= 18.736223) {
	      p = 1;
	    } else if (((Double) i[0]).doubleValue() > 18.736223) {
	    p = WekaClassifier0827Accel.N74056869101(i);
	    }
	    return p;
	  }
	  static double N74056869101(Object []i) {
	    double p = Double.NaN;
	    if (i[3] == null) {
	      p = 2;
	    } else if (((Double) i[3]).doubleValue() <= 2176.7053) {
	    p = WekaClassifier0827Accel.Nf0a0101102(i);
	    } else if (((Double) i[3]).doubleValue() > 2176.7053) {
	      p = 1;
	    }
	    return p;
	  }
	  static double Nf0a0101102(Object []i) {
	    double p = Double.NaN;
	    if (i[2] == null) {
	      p = 2;
	    } else if (((Double) i[2]).doubleValue() <= 143.9186) {
	      p = 2;
	    } else if (((Double) i[2]).doubleValue() > 143.9186) {
	    p = WekaClassifier0827Accel.N59c7f05d103(i);
	    }
	    return p;
	  }
	  static double N59c7f05d103(Object []i) {
	    double p = Double.NaN;
	    if (i[3] == null) {
	      p = 2;
	    } else if (((Double) i[3]).doubleValue() <= 1617.1044) {
	      p = 2;
	    } else if (((Double) i[3]).doubleValue() > 1617.1044) {
	      p = 1;
	    }
	    return p;
	  }
	  static double N557597b7104(Object []i) {
	    double p = Double.NaN;
	    if (i[0] == null) {
	      p = 1;
	    } else if (((Double) i[0]).doubleValue() <= 19.027666) {
	      p = 1;
	    } else if (((Double) i[0]).doubleValue() > 19.027666) {
	    p = WekaClassifier0827Accel.N1b3b9b36105(i);
	    }
	    return p;
	  }
	  static double N1b3b9b36105(Object []i) {
	    double p = Double.NaN;
	    if (i[2] == null) {
	      p = 1;
	    } else if (((Double) i[2]).doubleValue() <= 680.64056) {
	    p = WekaClassifier0827Accel.N664b0431106(i);
	    } else if (((Double) i[2]).doubleValue() > 680.64056) {
	      p = 1;
	    }
	    return p;
	  }
	  static double N664b0431106(Object []i) {
	    double p = Double.NaN;
	    if (i[3] == null) {
	      p = 1;
	    } else if (((Double) i[3]).doubleValue() <= 1871.7363) {
	    p = WekaClassifier0827Accel.N4700616e107(i);
	    } else if (((Double) i[3]).doubleValue() > 1871.7363) {
	      p = 1;
	    }
	    return p;
	  }
	  static double N4700616e107(Object []i) {
	    double p = Double.NaN;
	    if (i[0] == null) {
	      p = 1;
	    } else if (((Double) i[0]).doubleValue() <= 20.886213) {
	      p = 1;
	    } else if (((Double) i[0]).doubleValue() > 20.886213) {
	    p = WekaClassifier0827Accel.N69fca12c108(i);
	    }
	    return p;
	  }
	  static double N69fca12c108(Object []i) {
	    double p = Double.NaN;
	    if (i[2] == null) {
	      p = 2;
	    } else if (((Double) i[2]).doubleValue() <= 635.9366) {
	      p = 2;
	    } else if (((Double) i[2]).doubleValue() > 635.9366) {
	      p = 1;
	    }
	    return p;
	  }
	  static double N48b98610109(Object []i) {
	    double p = Double.NaN;
	    if (i[2] == null) {
	      p = 2;
	    } else if (((Double) i[2]).doubleValue() <= 793.3678) {
	    p = WekaClassifier0827Accel.Nc10a9bd110(i);
	    } else if (((Double) i[2]).doubleValue() > 793.3678) {
	    p = WekaClassifier0827Accel.N3abbafc7123(i);
	    }
	    return p;
	  }
	  static double Nc10a9bd110(Object []i) {
	    double p = Double.NaN;
	    if (i[3] == null) {
	      p = 2;
	    } else if (((Double) i[3]).doubleValue() <= 2750.4814) {
	    p = WekaClassifier0827Accel.N19f7bd7b111(i);
	    } else if (((Double) i[3]).doubleValue() > 2750.4814) {
	    p = WekaClassifier0827Accel.N6ac1d751118(i);
	    }
	    return p;
	  }
	  static double N19f7bd7b111(Object []i) {
	    double p = Double.NaN;
	    if (i[1] == null) {
	      p = 2;
	    } else if (((Double) i[1]).doubleValue() <= 733.90125) {
	    p = WekaClassifier0827Accel.N57b8e38e112(i);
	    } else if (((Double) i[1]).doubleValue() > 733.90125) {
	    p = WekaClassifier0827Accel.N2b785b8a117(i);
	    }
	    return p;
	  }
	  static double N57b8e38e112(Object []i) {
	    double p = Double.NaN;
	    if (i[3] == null) {
	      p = 2;
	    } else if (((Double) i[3]).doubleValue() <= 1959.3539) {
	      p = 2;
	    } else if (((Double) i[3]).doubleValue() > 1959.3539) {
	    p = WekaClassifier0827Accel.N2b63aca0113(i);
	    }
	    return p;
	  }
	  static double N2b63aca0113(Object []i) {
	    double p = Double.NaN;
	    if (i[0] == null) {
	      p = 1;
	    } else if (((Double) i[0]).doubleValue() <= 25.758394) {
	    p = WekaClassifier0827Accel.N1cda52a1114(i);
	    } else if (((Double) i[0]).doubleValue() > 25.758394) {
	      p = 2;
	    }
	    return p;
	  }
	  static double N1cda52a1114(Object []i) {
	    double p = Double.NaN;
	    if (i[2] == null) {
	      p = 2;
	    } else if (((Double) i[2]).doubleValue() <= 171.71025) {
	      p = 2;
	    } else if (((Double) i[2]).doubleValue() > 171.71025) {
	    p = WekaClassifier0827Accel.N4166d6d3115(i);
	    }
	    return p;
	  }
	  static double N4166d6d3115(Object []i) {
	    double p = Double.NaN;
	    if (i[3] == null) {
	      p = 1;
	    } else if (((Double) i[3]).doubleValue() <= 2364.804) {
	      p = 1;
	    } else if (((Double) i[3]).doubleValue() > 2364.804) {
	    p = WekaClassifier0827Accel.N46a1d830116(i);
	    }
	    return p;
	  }
	  static double N46a1d830116(Object []i) {
	    double p = Double.NaN;
	    if (i[2] == null) {
	      p = 2;
	    } else if (((Double) i[2]).doubleValue() <= 433.30795) {
	      p = 2;
	    } else if (((Double) i[2]).doubleValue() > 433.30795) {
	      p = 1;
	    }
	    return p;
	  }
	  static double N2b785b8a117(Object []i) {
	    double p = Double.NaN;
	    if (i[0] == null) {
	      p = 1;
	    } else if (((Double) i[0]).doubleValue() <= 26.808762) {
	      p = 1;
	    } else if (((Double) i[0]).doubleValue() > 26.808762) {
	      p = 2;
	    }
	    return p;
	  }
	  static double N6ac1d751118(Object []i) {
	    double p = Double.NaN;
	    if (i[0] == null) {
	      p = 1;
	    } else if (((Double) i[0]).doubleValue() <= 29.039982) {
	    p = WekaClassifier0827Accel.N5c1f3d98119(i);
	    } else if (((Double) i[0]).doubleValue() > 29.039982) {
	    p = WekaClassifier0827Accel.N568b8271121(i);
	    }
	    return p;
	  }
	  static double N5c1f3d98119(Object []i) {
	    double p = Double.NaN;
	    if (i[2] == null) {
	      p = 1;
	    } else if (((Double) i[2]).doubleValue() <= 291.48038) {
	    p = WekaClassifier0827Accel.N704f568120(i);
	    } else if (((Double) i[2]).doubleValue() > 291.48038) {
	      p = 1;
	    }
	    return p;
	  }
	  static double N704f568120(Object []i) {
	    double p = Double.NaN;
	    if (i[3] == null) {
	      p = 2;
	    } else if (((Double) i[3]).doubleValue() <= 4827.769) {
	      p = 2;
	    } else if (((Double) i[3]).doubleValue() > 4827.769) {
	      p = 1;
	    }
	    return p;
	  }
	  static double N568b8271121(Object []i) {
	    double p = Double.NaN;
	    if (i[2] == null) {
	      p = 2;
	    } else if (((Double) i[2]).doubleValue() <= 398.1906) {
	      p = 2;
	    } else if (((Double) i[2]).doubleValue() > 398.1906) {
	    p = WekaClassifier0827Accel.N6120f51a122(i);
	    }
	    return p;
	  }
	  static double N6120f51a122(Object []i) {
	    double p = Double.NaN;
	    if (i[3] == null) {
	      p = 2;
	    } else if (((Double) i[3]).doubleValue() <= 3356.8633) {
	      p = 2;
	    } else if (((Double) i[3]).doubleValue() > 3356.8633) {
	      p = 1;
	    }
	    return p;
	  }
	  static double N3abbafc7123(Object []i) {
	    double p = Double.NaN;
	    if (i[2] == null) {
	      p = 1;
	    } else if (((Double) i[2]).doubleValue() <= 1693.518) {
	    p = WekaClassifier0827Accel.N78114ff0124(i);
	    } else if (((Double) i[2]).doubleValue() > 1693.518) {
	      p = 1;
	    }
	    return p;
	  }
	  static double N78114ff0124(Object []i) {
	    double p = Double.NaN;
	    if (i[3] == null) {
	      p = 1;
	    } else if (((Double) i[3]).doubleValue() <= 2964.4954) {
	    p = WekaClassifier0827Accel.N38975325125(i);
	    } else if (((Double) i[3]).doubleValue() > 2964.4954) {
	      p = 1;
	    }
	    return p;
	  }
	  static double N38975325125(Object []i) {
	    double p = Double.NaN;
	    if (i[0] == null) {
	      p = 1;
	    } else if (((Double) i[0]).doubleValue() <= 28.244783) {
	    p = WekaClassifier0827Accel.N56d3bf29126(i);
	    } else if (((Double) i[0]).doubleValue() > 28.244783) {
	    p = WekaClassifier0827Accel.N45830b05130(i);
	    }
	    return p;
	  }
	  static double N56d3bf29126(Object []i) {
	    double p = Double.NaN;
	    if (i[1] == null) {
	      p = 1;
	    } else if (((Double) i[1]).doubleValue() <= 72.004875) {
	    p = WekaClassifier0827Accel.N67ab4947127(i);
	    } else if (((Double) i[1]).doubleValue() > 72.004875) {
	    p = WekaClassifier0827Accel.N1e58097d128(i);
	    }
	    return p;
	  }
	  static double N67ab4947127(Object []i) {
	    double p = Double.NaN;
	    if (i[3] == null) {
	      p = 2;
	    } else if (((Double) i[3]).doubleValue() <= 1794.6836) {
	      p = 2;
	    } else if (((Double) i[3]).doubleValue() > 1794.6836) {
	      p = 1;
	    }
	    return p;
	  }
	  static double N1e58097d128(Object []i) {
	    double p = Double.NaN;
	    if (i[2] == null) {
	      p = 1;
	    } else if (((Double) i[2]).doubleValue() <= 1079.1598) {
	    p = WekaClassifier0827Accel.N25d6fd1b129(i);
	    } else if (((Double) i[2]).doubleValue() > 1079.1598) {
	      p = 1;
	    }
	    return p;
	  }
	  static double N25d6fd1b129(Object []i) {
	    double p = Double.NaN;
	    if (i[0] == null) {
	      p = 1;
	    } else if (((Double) i[0]).doubleValue() <= 26.362774) {
	      p = 1;
	    } else if (((Double) i[0]).doubleValue() > 26.362774) {
	      p = 2;
	    }
	    return p;
	  }
	  static double N45830b05130(Object []i) {
	    double p = Double.NaN;
	    if (i[2] == null) {
	      p = 2;
	    } else if (((Double) i[2]).doubleValue() <= 1003.128) {
	      p = 2;
	    } else if (((Double) i[2]).doubleValue() > 1003.128) {
	    p = WekaClassifier0827Accel.N1e4898ea131(i);
	    }
	    return p;
	  }
	  static double N1e4898ea131(Object []i) {
	    double p = Double.NaN;
	    if (i[0] == null) {
	      p = 1;
	    } else if (((Double) i[0]).doubleValue() <= 31.45509) {
	      p = 1;
	    } else if (((Double) i[0]).doubleValue() > 31.45509) {
	      p = 2;
	    }
	    return p;
	  }
	  static double N302f3a2e132(Object []i) {
	    double p = Double.NaN;
	    if (i[0] == null) {
	      p = 2;
	    } else if (((Double) i[0]).doubleValue() <= 38.485138) {
	    p = WekaClassifier0827Accel.N6c94bab8133(i);
	    } else if (((Double) i[0]).doubleValue() > 38.485138) {
	    p = WekaClassifier0827Accel.N7047125143(i);
	    }
	    return p;
	  }
	  static double N6c94bab8133(Object []i) {
	    double p = Double.NaN;
	    if (i[2] == null) {
	      p = 2;
	    } else if (((Double) i[2]).doubleValue() <= 1041.4252) {
	      p = 2;
	    } else if (((Double) i[2]).doubleValue() > 1041.4252) {
	    p = WekaClassifier0827Accel.N186ebdb9134(i);
	    }
	    return p;
	  }
	  static double N186ebdb9134(Object []i) {
	    double p = Double.NaN;
	    if (i[0] == null) {
	      p = 1;
	    } else if (((Double) i[0]).doubleValue() <= 35.45486) {
	    p = WekaClassifier0827Accel.Ne69c937135(i);
	    } else if (((Double) i[0]).doubleValue() > 35.45486) {
	    p = WekaClassifier0827Accel.N1348e928139(i);
	    }
	    return p;
	  }
	  static double Ne69c937135(Object []i) {
	    double p = Double.NaN;
	    if (i[2] == null) {
	      p = 2;
	    } else if (((Double) i[2]).doubleValue() <= 1230.1129) {
	    p = WekaClassifier0827Accel.N43194145136(i);
	    } else if (((Double) i[2]).doubleValue() > 1230.1129) {
	      p = 1;
	    }
	    return p;
	  }
	  static double N43194145136(Object []i) {
	    double p = Double.NaN;
	    if (i[3] == null) {
	      p = 2;
	    } else if (((Double) i[3]).doubleValue() <= 4113.723) {
	      p = 2;
	    } else if (((Double) i[3]).doubleValue() > 4113.723) {
	    p = WekaClassifier0827Accel.N2f0c3b6d137(i);
	    }
	    return p;
	  }
	  static double N2f0c3b6d137(Object []i) {
	    double p = Double.NaN;
	    if (i[0] == null) {
	      p = 1;
	    } else if (((Double) i[0]).doubleValue() <= 34.31287) {
	      p = 1;
	    } else if (((Double) i[0]).doubleValue() > 34.31287) {
	    p = WekaClassifier0827Accel.N4c11893c138(i);
	    }
	    return p;
	  }
	  static double N4c11893c138(Object []i) {
	    double p = Double.NaN;
	    if (i[2] == null) {
	      p = 1;
	    } else if (((Double) i[2]).doubleValue() <= 1051.4161) {
	      p = 1;
	    } else if (((Double) i[2]).doubleValue() > 1051.4161) {
	      p = 2;
	    }
	    return p;
	  }
	  static double N1348e928139(Object []i) {
	    double p = Double.NaN;
	    if (i[3] == null) {
	      p = 2;
	    } else if (((Double) i[3]).doubleValue() <= 7738.725) {
	    p = WekaClassifier0827Accel.N17c34afc140(i);
	    } else if (((Double) i[3]).doubleValue() > 7738.725) {
	    p = WekaClassifier0827Accel.Nf9ede0e142(i);
	    }
	    return p;
	  }
	  static double N17c34afc140(Object []i) {
	    double p = Double.NaN;
	    if (i[2] == null) {
	      p = 2;
	    } else if (((Double) i[2]).doubleValue() <= 2796.4265) {
	      p = 2;
	    } else if (((Double) i[2]).doubleValue() > 2796.4265) {
	    p = WekaClassifier0827Accel.N166ff294141(i);
	    }
	    return p;
	  }
	  static double N166ff294141(Object []i) {
	    double p = Double.NaN;
	    if (i[1] == null) {
	      p = 2;
	    } else if (((Double) i[1]).doubleValue() <= 934.1133) {
	      p = 2;
	    } else if (((Double) i[1]).doubleValue() > 934.1133) {
	      p = 1;
	    }
	    return p;
	  }
	  static double Nf9ede0e142(Object []i) {
	    double p = Double.NaN;
	    if (i[1] == null) {
	      p = 2;
	    } else if (((Double) i[1]).doubleValue() <= 28.44095) {
	      p = 2;
	    } else if (((Double) i[1]).doubleValue() > 28.44095) {
	      p = 1;
	    }
	    return p;
	  }
	  static double N7047125143(Object []i) {
	    double p = Double.NaN;
	    if (i[2] == null) {
	      p = 2;
	    } else if (((Double) i[2]).doubleValue() <= 1220.9525) {
	      p = 2;
	    } else if (((Double) i[2]).doubleValue() > 1220.9525) {
	    p = WekaClassifier0827Accel.N34a037bc144(i);
	    }
	    return p;
	  }
	  static double N34a037bc144(Object []i) {
	    double p = Double.NaN;
	    if (i[0] == null) {
	      p = 2;
	    } else if (((Double) i[0]).doubleValue() <= 49.99063) {
	    p = WekaClassifier0827Accel.N2ab32a2145(i);
	    } else if (((Double) i[0]).doubleValue() > 49.99063) {
	      p = 2;
	    }
	    return p;
	  }
	  static double N2ab32a2145(Object []i) {
	    double p = Double.NaN;
	    if (i[2] == null) {
	      p = 2;
	    } else if (((Double) i[2]).doubleValue() <= 2450.744) {
	      p = 2;
	    } else if (((Double) i[2]).doubleValue() > 2450.744) {
	    p = WekaClassifier0827Accel.N35892b0c146(i);
	    }
	    return p;
	  }
	  static double N35892b0c146(Object []i) {
	    double p = Double.NaN;
	    if (i[2] == null) {
	      p = 2;
	    } else if (((Double) i[2]).doubleValue() <= 4649.316) {
	    p = WekaClassifier0827Accel.N40693c49147(i);
	    } else if (((Double) i[2]).doubleValue() > 4649.316) {
	      p = 1;
	    }
	    return p;
	  }
	  static double N40693c49147(Object []i) {
	    double p = Double.NaN;
	    if (i[1] == null) {
	      p = 2;
	    } else if (((Double) i[1]).doubleValue() <= 1238.3652) {
	      p = 2;
	    } else if (((Double) i[1]).doubleValue() > 1238.3652) {
	      p = 1;
	    }
	    return p;
	  }
}


//速度も加速度も用いる場合の識別メソッド
//（WekaのJ48にて自動生成）
class WekaClassifier0827 {

	  public static double classify(Object[] i)
	    throws Exception {

	    double p = Double.NaN;
	    p = WekaClassifier0827.N1a2f6aea0(i);
	    return p;
	  }
	  static double N1a2f6aea0(Object []i) {
	    double p = Double.NaN;
	    if (i[1] == null) {
	      p = 1;
	    } else if (((Double) i[1]).doubleValue() <= 33.283432) {
	    p = WekaClassifier0827.N1f1436141(i);
	    } else if (((Double) i[1]).doubleValue() > 33.283432) {
	    p = WekaClassifier0827.N2b23751260(i);
	    }
	    return p;
	  }
	  static double N1f1436141(Object []i) {
	    double p = Double.NaN;
	    if (i[1] == null) {
	      p = 0;
	    } else if (((Double) i[1]).doubleValue() <= 2.2482414) {
	    p = WekaClassifier0827.N67ea6afc2(i);
	    } else if (((Double) i[1]).doubleValue() > 2.2482414) {
	    p = WekaClassifier0827.N754e912d6(i);
	    }
	    return p;
	  }
	  static double N67ea6afc2(Object []i) {
	    double p = Double.NaN;
	    if (i[3] == null) {
	      p = 0;
	    } else if (((Double) i[3]).doubleValue() <= 53.107822) {
	      p = 0;
	    } else if (((Double) i[3]).doubleValue() > 53.107822) {
	    p = WekaClassifier0827.N4f15fbb03(i);
	    }
	    return p;
	  }
	  static double N4f15fbb03(Object []i) {
	    double p = Double.NaN;
	    if (i[3] == null) {
	      p = 0;
	    } else if (((Double) i[3]).doubleValue() <= 170.68503) {
	    p = WekaClassifier0827.N2c3f08604(i);
	    } else if (((Double) i[3]).doubleValue() > 170.68503) {
	      p = 1;
	    }
	    return p;
	  }
	  static double N2c3f08604(Object []i) {
	    double p = Double.NaN;
	    if (i[2] == null) {
	      p = 0;
	    } else if (((Double) i[2]).doubleValue() <= 37.185005) {
	      p = 0;
	    } else if (((Double) i[2]).doubleValue() > 37.185005) {
	    p = WekaClassifier0827.N5e3eed515(i);
	    }
	    return p;
	  }
	  static double N5e3eed515(Object []i) {
	    double p = Double.NaN;
	    if (i[2] == null) {
	      p = 1;
	    } else if (((Double) i[2]).doubleValue() <= 40.952526) {
	      p = 1;
	    } else if (((Double) i[2]).doubleValue() > 40.952526) {
	      p = 0;
	    }
	    return p;
	  }
	  static double N754e912d6(Object []i) {
	    double p = Double.NaN;
	    if (i[0] == null) {
	      p = 1;
	    } else if (((Double) i[0]).doubleValue() <= 1.9525625) {
	    p = WekaClassifier0827.N791d5d857(i);
	    } else if (((Double) i[0]).doubleValue() > 1.9525625) {
	    p = WekaClassifier0827.N28f25f8928(i);
	    }
	    return p;
	  }
	  static double N791d5d857(Object []i) {
	    double p = Double.NaN;
	    if (i[1] == null) {
	      p = 1;
	    } else if (((Double) i[1]).doubleValue() <= 25.324568) {
	      p = 1;
	    } else if (((Double) i[1]).doubleValue() > 25.324568) {
	    p = WekaClassifier0827.N76e704e18(i);
	    }
	    return p;
	  }
	  static double N76e704e18(Object []i) {
	    double p = Double.NaN;
	    if (i[3] == null) {
	      p = 1;
	    } else if (((Double) i[3]).doubleValue() <= 866.3254) {
	    p = WekaClassifier0827.N38f18cc39(i);
	    } else if (((Double) i[3]).doubleValue() > 866.3254) {
	    p = WekaClassifier0827.N1739422b21(i);
	    }
	    return p;
	  }
	  static double N38f18cc39(Object []i) {
	    double p = Double.NaN;
	    if (i[1] == null) {
	      p = 1;
	    } else if (((Double) i[1]).doubleValue() <= 29.300726) {
	    p = WekaClassifier0827.N7a50736910(i);
	    } else if (((Double) i[1]).doubleValue() > 29.300726) {
	    p = WekaClassifier0827.N71f250e814(i);
	    }
	    return p;
	  }
	  static double N7a50736910(Object []i) {
	    double p = Double.NaN;
	    if (i[4] == null) {
	      p = 1;
	    } else if (((Double) i[4]).doubleValue() <= 2485.0554) {
	    p = WekaClassifier0827.N37c9313b11(i);
	    } else if (((Double) i[4]).doubleValue() > 2485.0554) {
	      p = 1;
	    }
	    return p;
	  }
	  static double N37c9313b11(Object []i) {
	    double p = Double.NaN;
	    if (i[2] == null) {
	      p = 2;
	    } else if (((Double) i[2]).doubleValue() <= 241.13966) {
	      p = 2;
	    } else if (((Double) i[2]).doubleValue() > 241.13966) {
	    p = WekaClassifier0827.N79bf351912(i);
	    }
	    return p;
	  }
	  static double N79bf351912(Object []i) {
	    double p = Double.NaN;
	    if (i[0] == null) {
	      p = 1;
	    } else if (((Double) i[0]).doubleValue() <= 0.25) {
	    p = WekaClassifier0827.N78373ac013(i);
	    } else if (((Double) i[0]).doubleValue() > 0.25) {
	      p = 1;
	    }
	    return p;
	  }
	  static double N78373ac013(Object []i) {
	    double p = Double.NaN;
	    if (i[1] == null) {
	      p = 2;
	    } else if (((Double) i[1]).doubleValue() <= 25.796278) {
	      p = 2;
	    } else if (((Double) i[1]).doubleValue() > 25.796278) {
	      p = 1;
	    }
	    return p;
	  }
	  static double N71f250e814(Object []i) {
	    double p = Double.NaN;
	    if (i[3] == null) {
	      p = 2;
	    } else if (((Double) i[3]).doubleValue() <= 360.0623) {
	    p = WekaClassifier0827.N5b9de9c915(i);
	    } else if (((Double) i[3]).doubleValue() > 360.0623) {
	    p = WekaClassifier0827.N10b3b3a517(i);
	    }
	    return p;
	  }
	  static double N5b9de9c915(Object []i) {
	    double p = Double.NaN;
	    if (i[4] == null) {
	      p = 2;
	    } else if (((Double) i[4]).doubleValue() <= 7012.0786) {
	      p = 2;
	    } else if (((Double) i[4]).doubleValue() > 7012.0786) {
	    p = WekaClassifier0827.N5c5fba1c16(i);
	    }
	    return p;
	  }
	  static double N5c5fba1c16(Object []i) {
	    double p = Double.NaN;
	    if (i[0] == null) {
	      p = 1;
	    } else if (((Double) i[0]).doubleValue() <= 1.0) {
	      p = 1;
	    } else if (((Double) i[0]).doubleValue() > 1.0) {
	      p = 2;
	    }
	    return p;
	  }
	  static double N10b3b3a517(Object []i) {
	    double p = Double.NaN;
	    if (i[0] == null) {
	      p = 1;
	    } else if (((Double) i[0]).doubleValue() <= 1.5206907) {
	    p = WekaClassifier0827.N5d71e3418(i);
	    } else if (((Double) i[0]).doubleValue() > 1.5206907) {
	      p = 2;
	    }
	    return p;
	  }
	  static double N5d71e3418(Object []i) {
	    double p = Double.NaN;
	    if (i[4] == null) {
	      p = 2;
	    } else if (((Double) i[4]).doubleValue() <= 2743.8691) {
	    p = WekaClassifier0827.N6dffeaea19(i);
	    } else if (((Double) i[4]).doubleValue() > 2743.8691) {
	      p = 1;
	    }
	    return p;
	  }
	  static double N6dffeaea19(Object []i) {
	    double p = Double.NaN;
	    if (i[0] == null) {
	      p = 2;
	    } else if (((Double) i[0]).doubleValue() <= 0.75) {
	      p = 2;
	    } else if (((Double) i[0]).doubleValue() > 0.75) {
	    p = WekaClassifier0827.N3c97e11120(i);
	    }
	    return p;
	  }
	  static double N3c97e11120(Object []i) {
	    double p = Double.NaN;
	    if (i[2] == null) {
	      p = 1;
	    } else if (((Double) i[2]).doubleValue() <= 237.41428) {
	      p = 1;
	    } else if (((Double) i[2]).doubleValue() > 237.41428) {
	      p = 2;
	    }
	    return p;
	  }
	  static double N1739422b21(Object []i) {
	    double p = Double.NaN;
	    if (i[1] == null) {
	      p = 1;
	    } else if (((Double) i[1]).doubleValue() <= 31.746668) {
	      p = 1;
	    } else if (((Double) i[1]).doubleValue() > 31.746668) {
	    p = WekaClassifier0827.N302720f622(i);
	    }
	    return p;
	  }
	  static double N302720f622(Object []i) {
	    double p = Double.NaN;
	    if (i[3] == null) {
	      p = 1;
	    } else if (((Double) i[3]).doubleValue() <= 1547.74) {
	    p = WekaClassifier0827.N58e50f2c23(i);
	    } else if (((Double) i[3]).doubleValue() > 1547.74) {
	      p = 1;
	    }
	    return p;
	  }
	  static double N58e50f2c23(Object []i) {
	    double p = Double.NaN;
	    if (i[4] == null) {
	      p = 2;
	    } else if (((Double) i[4]).doubleValue() <= 2003.6204) {
	      p = 2;
	    } else if (((Double) i[4]).doubleValue() > 2003.6204) {
	    p = WekaClassifier0827.N26473f4c24(i);
	    }
	    return p;
	  }
	  static double N26473f4c24(Object []i) {
	    double p = Double.NaN;
	    if (i[1] == null) {
	      p = 1;
	    } else if (((Double) i[1]).doubleValue() <= 33.02555) {
	    p = WekaClassifier0827.Nf8caa3625(i);
	    } else if (((Double) i[1]).doubleValue() > 33.02555) {
	    p = WekaClassifier0827.N2d2c147227(i);
	    }
	    return p;
	  }
	  static double Nf8caa3625(Object []i) {
	    double p = Double.NaN;
	    if (i[0] == null) {
	      p = 1;
	    } else if (((Double) i[0]).doubleValue() <= 1.6007811) {
	      p = 1;
	    } else if (((Double) i[0]).doubleValue() > 1.6007811) {
	    p = WekaClassifier0827.N5bfac73326(i);
	    }
	    return p;
	  }
	  static double N5bfac73326(Object []i) {
	    double p = Double.NaN;
	    if (i[4] == null) {
	      p = 1;
	    } else if (((Double) i[4]).doubleValue() <= 5583.048) {
	      p = 1;
	    } else if (((Double) i[4]).doubleValue() > 5583.048) {
	      p = 2;
	    }
	    return p;
	  }
	  static double N2d2c147227(Object []i) {
	    double p = Double.NaN;
	    if (i[1] == null) {
	      p = 2;
	    } else if (((Double) i[1]).doubleValue() <= 33.15513) {
	      p = 2;
	    } else if (((Double) i[1]).doubleValue() > 33.15513) {
	      p = 1;
	    }
	    return p;
	  }
	  static double N28f25f8928(Object []i) {
	    double p = Double.NaN;
	    if (i[1] == null) {
	      p = 1;
	    } else if (((Double) i[1]).doubleValue() <= 20.895824) {
	    p = WekaClassifier0827.N405e305f29(i);
	    } else if (((Double) i[1]).doubleValue() > 20.895824) {
	    p = WekaClassifier0827.N24e2834734(i);
	    }
	    return p;
	  }
	  static double N405e305f29(Object []i) {
	    double p = Double.NaN;
	    if (i[3] == null) {
	      p = 1;
	    } else if (((Double) i[3]).doubleValue() <= 341.36127) {
	    p = WekaClassifier0827.N67b9cdfc30(i);
	    } else if (((Double) i[3]).doubleValue() > 341.36127) {
	      p = 1;
	    }
	    return p;
	  }
	  static double N67b9cdfc30(Object []i) {
	    double p = Double.NaN;
	    if (i[4] == null) {
	      p = 2;
	    } else if (((Double) i[4]).doubleValue() <= 903.8172) {
	      p = 2;
	    } else if (((Double) i[4]).doubleValue() > 903.8172) {
	    p = WekaClassifier0827.N5782909731(i);
	    }
	    return p;
	  }
	  static double N5782909731(Object []i) {
	    double p = Double.NaN;
	    if (i[0] == null) {
	      p = 1;
	    } else if (((Double) i[0]).doubleValue() <= 3.473111) {
	    p = WekaClassifier0827.N3ce2d66332(i);
	    } else if (((Double) i[0]).doubleValue() > 3.473111) {
	      p = 2;
	    }
	    return p;
	  }
	  static double N3ce2d66332(Object []i) {
	    double p = Double.NaN;
	    if (i[1] == null) {
	      p = 1;
	    } else if (((Double) i[1]).doubleValue() <= 18.607422) {
	      p = 1;
	    } else if (((Double) i[1]).doubleValue() > 18.607422) {
	    p = WekaClassifier0827.N50691ccf33(i);
	    }
	    return p;
	  }
	  static double N50691ccf33(Object []i) {
	    double p = Double.NaN;
	    if (i[1] == null) {
	      p = 2;
	    } else if (((Double) i[1]).doubleValue() <= 19.746363) {
	      p = 2;
	    } else if (((Double) i[1]).doubleValue() > 19.746363) {
	      p = 1;
	    }
	    return p;
	  }
	  static double N24e2834734(Object []i) {
	    double p = Double.NaN;
	    if (i[3] == null) {
	      p = 2;
	    } else if (((Double) i[3]).doubleValue() <= 619.0212) {
	    p = WekaClassifier0827.N1318bd3c35(i);
	    } else if (((Double) i[3]).doubleValue() > 619.0212) {
	    p = WekaClassifier0827.Nf5e1241(i);
	    }
	    return p;
	  }
	  static double N1318bd3c35(Object []i) {
	    double p = Double.NaN;
	    if (i[4] == null) {
	      p = 2;
	    } else if (((Double) i[4]).doubleValue() <= 3120.3152) {
	      p = 2;
	    } else if (((Double) i[4]).doubleValue() > 3120.3152) {
	    p = WekaClassifier0827.N3d2fb7ef36(i);
	    }
	    return p;
	  }
	  static double N3d2fb7ef36(Object []i) {
	    double p = Double.NaN;
	    if (i[1] == null) {
	      p = 1;
	    } else if (((Double) i[1]).doubleValue() <= 27.574993) {
	    p = WekaClassifier0827.N7d4cb4b37(i);
	    } else if (((Double) i[1]).doubleValue() > 27.574993) {
	    p = WekaClassifier0827.N371c146339(i);
	    }
	    return p;
	  }
	  static double N7d4cb4b37(Object []i) {
	    double p = Double.NaN;
	    if (i[4] == null) {
	      p = 1;
	    } else if (((Double) i[4]).doubleValue() <= 4438.928) {
	    p = WekaClassifier0827.N236eacf138(i);
	    } else if (((Double) i[4]).doubleValue() > 4438.928) {
	      p = 1;
	    }
	    return p;
	  }
	  static double N236eacf138(Object []i) {
	    double p = Double.NaN;
	    if (i[4] == null) {
	      p = 1;
	    } else if (((Double) i[4]).doubleValue() <= 3779.6743) {
	      p = 1;
	    } else if (((Double) i[4]).doubleValue() > 3779.6743) {
	      p = 2;
	    }
	    return p;
	  }
	  static double N371c146339(Object []i) {
	    double p = Double.NaN;
	    if (i[4] == null) {
	      p = 2;
	    } else if (((Double) i[4]).doubleValue() <= 7437.8647) {
	      p = 2;
	    } else if (((Double) i[4]).doubleValue() > 7437.8647) {
	    p = WekaClassifier0827.N147e8bd940(i);
	    }
	    return p;
	  }
	  static double N147e8bd940(Object []i) {
	    double p = Double.NaN;
	    if (i[2] == null) {
	      p = 1;
	    } else if (((Double) i[2]).doubleValue() <= 345.5148) {
	      p = 1;
	    } else if (((Double) i[2]).doubleValue() > 345.5148) {
	      p = 2;
	    }
	    return p;
	  }
	  static double Nf5e1241(Object []i) {
	    double p = Double.NaN;
	    if (i[0] == null) {
	      p = 1;
	    } else if (((Double) i[0]).doubleValue() <= 2.6100767) {
	    p = WekaClassifier0827.N70e8efc542(i);
	    } else if (((Double) i[0]).doubleValue() > 2.6100767) {
	    p = WekaClassifier0827.N63adf08f51(i);
	    }
	    return p;
	  }
	  static double N70e8efc542(Object []i) {
	    double p = Double.NaN;
	    if (i[1] == null) {
	      p = 1;
	    } else if (((Double) i[1]).doubleValue() <= 27.356928) {
	    p = WekaClassifier0827.N4cd5a86c43(i);
	    } else if (((Double) i[1]).doubleValue() > 27.356928) {
	    p = WekaClassifier0827.N51af535045(i);
	    }
	    return p;
	  }
	  static double N4cd5a86c43(Object []i) {
	    double p = Double.NaN;
	    if (i[4] == null) {
	      p = 1;
	    } else if (((Double) i[4]).doubleValue() <= 824.2666) {
	    p = WekaClassifier0827.N5f2471dc44(i);
	    } else if (((Double) i[4]).doubleValue() > 824.2666) {
	      p = 1;
	    }
	    return p;
	  }
	  static double N5f2471dc44(Object []i) {
	    double p = Double.NaN;
	    if (i[3] == null) {
	      p = 2;
	    } else if (((Double) i[3]).doubleValue() <= 1509.0248) {
	      p = 2;
	    } else if (((Double) i[3]).doubleValue() > 1509.0248) {
	      p = 1;
	    }
	    return p;
	  }
	  static double N51af535045(Object []i) {
	    double p = Double.NaN;
	    if (i[3] == null) {
	      p = 2;
	    } else if (((Double) i[3]).doubleValue() <= 925.8846) {
	    p = WekaClassifier0827.N4d86d31546(i);
	    } else if (((Double) i[3]).doubleValue() > 925.8846) {
	    p = WekaClassifier0827.N4e8c2f7647(i);
	    }
	    return p;
	  }
	  static double N4d86d31546(Object []i) {
	    double p = Double.NaN;
	    if (i[2] == null) {
	      p = 2;
	    } else if (((Double) i[2]).doubleValue() <= 692.1697) {
	      p = 2;
	    } else if (((Double) i[2]).doubleValue() > 692.1697) {
	      p = 1;
	    }
	    return p;
	  }
	  static double N4e8c2f7647(Object []i) {
	    double p = Double.NaN;
	    if (i[1] == null) {
	      p = 1;
	    } else if (((Double) i[1]).doubleValue() <= 31.810238) {
	      p = 1;
	    } else if (((Double) i[1]).doubleValue() > 31.810238) {
	    p = WekaClassifier0827.N5580144348(i);
	    }
	    return p;
	  }
	  static double N5580144348(Object []i) {
	    double p = Double.NaN;
	    if (i[1] == null) {
	      p = 2;
	    } else if (((Double) i[1]).doubleValue() <= 32.882153) {
	    p = WekaClassifier0827.N4bb2668f49(i);
	    } else if (((Double) i[1]).doubleValue() > 32.882153) {
	      p = 1;
	    }
	    return p;
	  }
	  static double N4bb2668f49(Object []i) {
	    double p = Double.NaN;
	    if (i[1] == null) {
	      p = 2;
	    } else if (((Double) i[1]).doubleValue() <= 32.67569) {
	    p = WekaClassifier0827.N2d6b5d1c50(i);
	    } else if (((Double) i[1]).doubleValue() > 32.67569) {
	      p = 2;
	    }
	    return p;
	  }
	  static double N2d6b5d1c50(Object []i) {
	    double p = Double.NaN;
	    if (i[1] == null) {
	      p = 2;
	    } else if (((Double) i[1]).doubleValue() <= 32.511677) {
	      p = 2;
	    } else if (((Double) i[1]).doubleValue() > 32.511677) {
	      p = 1;
	    }
	    return p;
	  }
	  static double N63adf08f51(Object []i) {
	    double p = Double.NaN;
	    if (i[1] == null) {
	      p = 1;
	    } else if (((Double) i[1]).doubleValue() <= 23.401016) {
	    p = WekaClassifier0827.N308c6f6952(i);
	    } else if (((Double) i[1]).doubleValue() > 23.401016) {
	    p = WekaClassifier0827.N53e66f6553(i);
	    }
	    return p;
	  }
	  static double N308c6f6952(Object []i) {
	    double p = Double.NaN;
	    if (i[2] == null) {
	      p = 2;
	    } else if (((Double) i[2]).doubleValue() <= 27.160753) {
	      p = 2;
	    } else if (((Double) i[2]).doubleValue() > 27.160753) {
	      p = 1;
	    }
	    return p;
	  }
	  static double N53e66f6553(Object []i) {
	    double p = Double.NaN;
	    if (i[4] == null) {
	      p = 2;
	    } else if (((Double) i[4]).doubleValue() <= 3520.6646) {
	    p = WekaClassifier0827.N3d9b7aeb54(i);
	    } else if (((Double) i[4]).doubleValue() > 3520.6646) {
	    p = WekaClassifier0827.N27adc5f758(i);
	    }
	    return p;
	  }
	  static double N3d9b7aeb54(Object []i) {
	    double p = Double.NaN;
	    if (i[4] == null) {
	      p = 2;
	    } else if (((Double) i[4]).doubleValue() <= 1909.325) {
	      p = 2;
	    } else if (((Double) i[4]).doubleValue() > 1909.325) {
	    p = WekaClassifier0827.N2aa2f9e655(i);
	    }
	    return p;
	  }
	  static double N2aa2f9e655(Object []i) {
	    double p = Double.NaN;
	    if (i[1] == null) {
	      p = 1;
	    } else if (((Double) i[1]).doubleValue() <= 24.504858) {
	      p = 1;
	    } else if (((Double) i[1]).doubleValue() > 24.504858) {
	    p = WekaClassifier0827.N31c480e856(i);
	    }
	    return p;
	  }
	  static double N31c480e856(Object []i) {
	    double p = Double.NaN;
	    if (i[3] == null) {
	      p = 2;
	    } else if (((Double) i[3]).doubleValue() <= 1618.4478) {
	      p = 2;
	    } else if (((Double) i[3]).doubleValue() > 1618.4478) {
	    p = WekaClassifier0827.N5beb18de57(i);
	    }
	    return p;
	  }
	  static double N5beb18de57(Object []i) {
	    double p = Double.NaN;
	    if (i[0] == null) {
	      p = 2;
	    } else if (((Double) i[0]).doubleValue() <= 4.25) {
	      p = 2;
	    } else if (((Double) i[0]).doubleValue() > 4.25) {
	      p = 1;
	    }
	    return p;
	  }
	  static double N27adc5f758(Object []i) {
	    double p = Double.NaN;
	    if (i[1] == null) {
	      p = 1;
	    } else if (((Double) i[1]).doubleValue() <= 28.670652) {
	      p = 1;
	    } else if (((Double) i[1]).doubleValue() > 28.670652) {
	    p = WekaClassifier0827.N19fef7b59(i);
	    }
	    return p;
	  }
	  static double N19fef7b59(Object []i) {
	    double p = Double.NaN;
	    if (i[0] == null) {
	      p = 2;
	    } else if (((Double) i[0]).doubleValue() <= 3.5) {
	      p = 2;
	    } else if (((Double) i[0]).doubleValue() > 3.5) {
	      p = 1;
	    }
	    return p;
	  }
	  static double N2b23751260(Object []i) {
	    double p = Double.NaN;
	    if (i[1] == null) {
	      p = 2;
	    } else if (((Double) i[1]).doubleValue() <= 38.485138) {
	    p = WekaClassifier0827.N24db06de61(i);
	    } else if (((Double) i[1]).doubleValue() > 38.485138) {
	    p = WekaClassifier0827.N6eaecd5168(i);
	    }
	    return p;
	  }
	  static double N24db06de61(Object []i) {
	    double p = Double.NaN;
	    if (i[3] == null) {
	      p = 2;
	    } else if (((Double) i[3]).doubleValue() <= 1041.4252) {
	      p = 2;
	    } else if (((Double) i[3]).doubleValue() > 1041.4252) {
	    p = WekaClassifier0827.N279febb962(i);
	    }
	    return p;
	  }
	  static double N279febb962(Object []i) {
	    double p = Double.NaN;
	    if (i[0] == null) {
	      p = 1;
	    } else if (((Double) i[0]).doubleValue() <= 1.5206907) {
	    p = WekaClassifier0827.N742cd30163(i);
	    } else if (((Double) i[0]).doubleValue() > 1.5206907) {
	      p = 2;
	    }
	    return p;
	  }
	  static double N742cd30163(Object []i) {
	    double p = Double.NaN;
	    if (i[3] == null) {
	      p = 1;
	    } else if (((Double) i[3]).doubleValue() <= 3407.2876) {
	    p = WekaClassifier0827.N2ad1223d64(i);
	    } else if (((Double) i[3]).doubleValue() > 3407.2876) {
	      p = 1;
	    }
	    return p;
	  }
	  static double N2ad1223d64(Object []i) {
	    double p = Double.NaN;
	    if (i[1] == null) {
	      p = 1;
	    } else if (((Double) i[1]).doubleValue() <= 35.114746) {
	      p = 1;
	    } else if (((Double) i[1]).doubleValue() > 35.114746) {
	    p = WekaClassifier0827.N81ee8c165(i);
	    }
	    return p;
	  }
	  static double N81ee8c165(Object []i) {
	    double p = Double.NaN;
	    if (i[4] == null) {
	      p = 2;
	    } else if (((Double) i[4]).doubleValue() <= 7667.8022) {
	    p = WekaClassifier0827.N2542db1166(i);
	    } else if (((Double) i[4]).doubleValue() > 7667.8022) {
	      p = 1;
	    }
	    return p;
	  }
	  static double N2542db1166(Object []i) {
	    double p = Double.NaN;
	    if (i[3] == null) {
	      p = 2;
	    } else if (((Double) i[3]).doubleValue() <= 1289.581) {
	      p = 2;
	    } else if (((Double) i[3]).doubleValue() > 1289.581) {
	    p = WekaClassifier0827.N483c4c3367(i);
	    }
	    return p;
	  }
	  static double N483c4c3367(Object []i) {
	    double p = Double.NaN;
	    if (i[2] == null) {
	      p = 2;
	    } else if (((Double) i[2]).doubleValue() <= 195.99321) {
	      p = 2;
	    } else if (((Double) i[2]).doubleValue() > 195.99321) {
	      p = 1;
	    }
	    return p;
	  }
	  static double N6eaecd5168(Object []i) {
	    double p = Double.NaN;
	    if (i[0] == null) {
	      p = 2;
	    } else if (((Double) i[0]).doubleValue() <= 1.0) {
	    p = WekaClassifier0827.N1629b99c69(i);
	    } else if (((Double) i[0]).doubleValue() > 1.0) {
	      p = 2;
	    }
	    return p;
	  }
	  static double N1629b99c69(Object []i) {
	    double p = Double.NaN;
	    if (i[3] == null) {
	      p = 2;
	    } else if (((Double) i[3]).doubleValue() <= 566.0597) {
	      p = 2;
	    } else if (((Double) i[3]).doubleValue() > 566.0597) {
	    p = WekaClassifier0827.Nd58bc2270(i);
	    }
	    return p;
	  }
	  static double Nd58bc2270(Object []i) {
	    double p = Double.NaN;
	    if (i[1] == null) {
	      p = 2;
	    } else if (((Double) i[1]).doubleValue() <= 49.98992) {
	    p = WekaClassifier0827.N3ca7630671(i);
	    } else if (((Double) i[1]).doubleValue() > 49.98992) {
	      p = 2;
	    }
	    return p;
	  }
	  static double N3ca7630671(Object []i) {
	    double p = Double.NaN;
	    if (i[3] == null) {
	      p = 2;
	    } else if (((Double) i[3]).doubleValue() <= 2447.3657) {
	    p = WekaClassifier0827.N11563e0672(i);
	    } else if (((Double) i[3]).doubleValue() > 2447.3657) {
	    p = WekaClassifier0827.N748455dd77(i);
	    }
	    return p;
	  }
	  static double N11563e0672(Object []i) {
	    double p = Double.NaN;
	    if (i[0] == null) {
	      p = 2;
	    } else if (((Double) i[0]).doubleValue() <= 0.0) {
	      p = 2;
	    } else if (((Double) i[0]).doubleValue() > 0.0) {
	    p = WekaClassifier0827.N350204ce73(i);
	    }
	    return p;
	  }
	  static double N350204ce73(Object []i) {
	    double p = Double.NaN;
	    if (i[4] == null) {
	      p = 2;
	    } else if (((Double) i[4]).doubleValue() <= 6477.202) {
	      p = 2;
	    } else if (((Double) i[4]).doubleValue() > 6477.202) {
	    p = WekaClassifier0827.N17898b9274(i);
	    }
	    return p;
	  }
	  static double N17898b9274(Object []i) {
	    double p = Double.NaN;
	    if (i[0] == null) {
	      p = 1;
	    } else if (((Double) i[0]).doubleValue() <= 0.5) {
	      p = 1;
	    } else if (((Double) i[0]).doubleValue() > 0.5) {
	    p = WekaClassifier0827.N472a2a5075(i);
	    }
	    return p;
	  }
	  static double N472a2a5075(Object []i) {
	    double p = Double.NaN;
	    if (i[0] == null) {
	      p = 2;
	    } else if (((Double) i[0]).doubleValue() <= 0.75) {
	    p = WekaClassifier0827.N21400eb076(i);
	    } else if (((Double) i[0]).doubleValue() > 0.75) {
	      p = 2;
	    }
	    return p;
	  }
	  static double N21400eb076(Object []i) {
	    double p = Double.NaN;
	    if (i[1] == null) {
	      p = 1;
	    } else if (((Double) i[1]).doubleValue() <= 41.24802) {
	      p = 1;
	    } else if (((Double) i[1]).doubleValue() > 41.24802) {
	      p = 2;
	    }
	    return p;
	  }
	  static double N748455dd77(Object []i) {
	    double p = Double.NaN;
	    if (i[0] == null) {
	      p = 2;
	    } else if (((Double) i[0]).doubleValue() <= 0.0) {
	    p = WekaClassifier0827.N1c215bee78(i);
	    } else if (((Double) i[0]).doubleValue() > 0.0) {
	    p = WekaClassifier0827.N521a74af79(i);
	    }
	    return p;
	  }
	  static double N1c215bee78(Object []i) {
	    double p = Double.NaN;
	    if (i[4] == null) {
	      p = 1;
	    } else if (((Double) i[4]).doubleValue() <= 2927.92) {
	      p = 1;
	    } else if (((Double) i[4]).doubleValue() > 2927.92) {
	      p = 2;
	    }
	    return p;
	  }
	  static double N521a74af79(Object []i) {
	    double p = Double.NaN;
	    if (i[3] == null) {
	      p = 2;
	    } else if (((Double) i[3]).doubleValue() <= 3462.8594) {
	    p = WekaClassifier0827.N46e2b74580(i);
	    } else if (((Double) i[3]).doubleValue() > 3462.8594) {
	    p = WekaClassifier0827.N18154bb184(i);
	    }
	    return p;
	  }
	  static double N46e2b74580(Object []i) {
	    double p = Double.NaN;
	    if (i[4] == null) {
	      p = 2;
	    } else if (((Double) i[4]).doubleValue() <= 8401.233) {
	    p = WekaClassifier0827.N4e6e375e81(i);
	    } else if (((Double) i[4]).doubleValue() > 8401.233) {
	    p = WekaClassifier0827.N13276cc83(i);
	    }
	    return p;
	  }
	  static double N4e6e375e81(Object []i) {
	    double p = Double.NaN;
	    if (i[4] == null) {
	      p = 1;
	    } else if (((Double) i[4]).doubleValue() <= 6258.6226) {
	    p = WekaClassifier0827.N25f5248c82(i);
	    } else if (((Double) i[4]).doubleValue() > 6258.6226) {
	      p = 2;
	    }
	    return p;
	  }
	  static double N25f5248c82(Object []i) {
	    double p = Double.NaN;
	    if (i[0] == null) {
	      p = 2;
	    } else if (((Double) i[0]).doubleValue() <= 0.5) {
	      p = 2;
	    } else if (((Double) i[0]).doubleValue() > 0.5) {
	      p = 1;
	    }
	    return p;
	  }
	  static double N13276cc83(Object []i) {
	    double p = Double.NaN;
	    if (i[4] == null) {
	      p = 1;
	    } else if (((Double) i[4]).doubleValue() <= 13016.886) {
	      p = 1;
	    } else if (((Double) i[4]).doubleValue() > 13016.886) {
	      p = 2;
	    }
	    return p;
	  }
	  static double N18154bb184(Object []i) {
	    double p = Double.NaN;
	    if (i[2] == null) {
	      p = 1;
	    } else if (((Double) i[2]).doubleValue() <= 399.5487) {
	    p = WekaClassifier0827.N1e1c5dd185(i);
	    } else if (((Double) i[2]).doubleValue() > 399.5487) {
	      p = 1;
	    }
	    return p;
	  }
	  static double N1e1c5dd185(Object []i) {
	    double p = Double.NaN;
	    if (i[0] == null) {
	      p = 1;
	    } else if (((Double) i[0]).doubleValue() <= 0.25) {
	      p = 1;
	    } else if (((Double) i[0]).doubleValue() > 0.25) {
	      p = 2;
	    }
	    return p;
	  }
}
