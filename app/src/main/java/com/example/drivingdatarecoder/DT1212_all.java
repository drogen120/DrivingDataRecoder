package com.example.drivingdatarecoder;

public class DT1212_all {
	//各移動モードに対応する番号
	public static final int MODE_OTHER = 0; //=still
	public static final int MODE_WALK = 1;
	public static final int MODE_RUN = 2;
	public static final int MODE_METRO = 4;

	//コンストラクタ（何もしない）
	public DT1212_all(){ }

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


//識別メソッド
//（WekaのJ48にて自動生成）
class WekaClassifier1212_all {

	  public static double classify(Object[] i)
	    throws Exception {

	    double p = Double.NaN;
	    p = WekaClassifier1212_all.N1299ee0b93(i);
	    return p;
	  }
	  static double N1299ee0b93(Object []i) {
	    double p = Double.NaN;
	    if (i[1] == null) {
	      p = 0;
	    } else if (((Double) i[1]).doubleValue() <= 2.2482414) {
	    p = WekaClassifier1212_all.N37db1db794(i);
	    } else if (((Double) i[1]).doubleValue() > 2.2482414) {
	    p = WekaClassifier1212_all.N56aeecff127(i);
	    }
	    return p;
	  }
	  static double N37db1db794(Object []i) {
	    double p = Double.NaN;
	    if (i[0] == null) {
	      p = 0;
	    } else if (((Double) i[0]).doubleValue() <= 0.0) {
	    p = WekaClassifier1212_all.N127bf60795(i);
	    } else if (((Double) i[0]).doubleValue() > 0.0) {
	    p = WekaClassifier1212_all.N447ec736109(i);
	    }
	    return p;
	  }
	  static double N127bf60795(Object []i) {
	    double p = Double.NaN;
	    if (i[1] == null) {
	      p = 0;
	    } else if (((Double) i[1]).doubleValue() <= 0.0028575668) {
	      p = 0;
	    } else if (((Double) i[1]).doubleValue() > 0.0028575668) {
	    p = WekaClassifier1212_all.N8554f0c96(i);
	    }
	    return p;
	  }
	  static double N8554f0c96(Object []i) {
	    double p = Double.NaN;
	    if (i[1] == null) {
	      p = 4;
	    } else if (((Double) i[1]).doubleValue() <= 0.17077246) {
	    p = WekaClassifier1212_all.N18b8a11a97(i);
	    } else if (((Double) i[1]).doubleValue() > 0.17077246) {
	    p = WekaClassifier1212_all.N6de40a47105(i);
	    }
	    return p;
	  }
	  static double N18b8a11a97(Object []i) {
	    double p = Double.NaN;
	    if (i[1] == null) {
	      p = 0;
	    } else if (((Double) i[1]).doubleValue() <= 0.0041673053) {
	      p = 0;
	    } else if (((Double) i[1]).doubleValue() > 0.0041673053) {
	    p = WekaClassifier1212_all.N158bea498(i);
	    }
	    return p;
	  }
	  static double N158bea498(Object []i) {
	    double p = Double.NaN;
	    if (i[3] == null) {
	      p = 4;
	    } else if (((Double) i[3]).doubleValue() <= 1.7725729) {
	      p = 4;
	    } else if (((Double) i[3]).doubleValue() > 1.7725729) {
	    p = WekaClassifier1212_all.N694c01ac99(i);
	    }
	    return p;
	  }
	  static double N694c01ac99(Object []i) {
	    double p = Double.NaN;
	    if (i[2] == null) {
	      p = 0;
	    } else if (((Double) i[2]).doubleValue() <= 2.812421) {
	    p = WekaClassifier1212_all.N7d01f935100(i);
	    } else if (((Double) i[2]).doubleValue() > 2.812421) {
	      p = 4;
	    }
	    return p;
	  }
	  static double N7d01f935100(Object []i) {
	    double p = Double.NaN;
	    if (i[2] == null) {
	      p = 4;
	    } else if (((Double) i[2]).doubleValue() <= 0.7118527) {
	    p = WekaClassifier1212_all.Nc9046b1101(i);
	    } else if (((Double) i[2]).doubleValue() > 0.7118527) {
	    p = WekaClassifier1212_all.N2d73b676103(i);
	    }
	    return p;
	  }
	  static double Nc9046b1101(Object []i) {
	    double p = Double.NaN;
	    if (i[2] == null) {
	      p = 0;
	    } else if (((Double) i[2]).doubleValue() <= 0.26662353) {
	    p = WekaClassifier1212_all.N541114e8102(i);
	    } else if (((Double) i[2]).doubleValue() > 0.26662353) {
	      p = 4;
	    }
	    return p;
	  }
	  static double N541114e8102(Object []i) {
	    double p = Double.NaN;
	    if (i[2] == null) {
	      p = 4;
	    } else if (((Double) i[2]).doubleValue() <= 0.12853122) {
	      p = 4;
	    } else if (((Double) i[2]).doubleValue() > 0.12853122) {
	      p = 0;
	    }
	    return p;
	  }
	  static double N2d73b676103(Object []i) {
	    double p = Double.NaN;
	    if (i[1] == null) {
	      p = 0;
	    } else if (((Double) i[1]).doubleValue() <= 0.12211886) {
	    p = WekaClassifier1212_all.N7d0144a104(i);
	    } else if (((Double) i[1]).doubleValue() > 0.12211886) {
	      p = 4;
	    }
	    return p;
	  }
	  static double N7d0144a104(Object []i) {
	    double p = Double.NaN;
	    if (i[1] == null) {
	      p = 0;
	    } else if (((Double) i[1]).doubleValue() <= 0.08204095) {
	      p = 0;
	    } else if (((Double) i[1]).doubleValue() > 0.08204095) {
	      p = 3;
	    }
	    return p;
	  }
	  static double N6de40a47105(Object []i) {
	    double p = Double.NaN;
	    if (i[2] == null) {
	      p = 0;
	    } else if (((Double) i[2]).doubleValue() <= 78.774574) {
	      p = 0;
	    } else if (((Double) i[2]).doubleValue() > 78.774574) {
	    p = WekaClassifier1212_all.N165ef3ae106(i);
	    }
	    return p;
	  }
	  static double N165ef3ae106(Object []i) {
	    double p = Double.NaN;
	    if (i[2] == null) {
	      p = 0;
	    } else if (((Double) i[2]).doubleValue() <= 149.74228) {
	    p = WekaClassifier1212_all.N33d02ffb107(i);
	    } else if (((Double) i[2]).doubleValue() > 149.74228) {
	      p = 4;
	    }
	    return p;
	  }
	  static double N33d02ffb107(Object []i) {
	    double p = Double.NaN;
	    if (i[2] == null) {
	      p = 4;
	    } else if (((Double) i[2]).doubleValue() <= 88.64265) {
	      p = 4;
	    } else if (((Double) i[2]).doubleValue() > 88.64265) {
	    p = WekaClassifier1212_all.N28fe2250108(i);
	    }
	    return p;
	  }
	  static double N28fe2250108(Object []i) {
	    double p = Double.NaN;
	    if (i[1] == null) {
	      p = 3;
	    } else if (((Double) i[1]).doubleValue() <= 1.2733055) {
	      p = 3;
	    } else if (((Double) i[1]).doubleValue() > 1.2733055) {
	      p = 0;
	    }
	    return p;
	  }
	  static double N447ec736109(Object []i) {
	    double p = Double.NaN;
	    if (i[0] == null) {
	      p = 3;
	    } else if (((Double) i[0]).doubleValue() <= 7.1243296) {
	    p = WekaClassifier1212_all.N5f48cd5b110(i);
	    } else if (((Double) i[0]).doubleValue() > 7.1243296) {
	      p = 4;
	    }
	    return p;
	  }
	  static double N5f48cd5b110(Object []i) {
	    double p = Double.NaN;
	    if (i[0] == null) {
	      p = 1;
	    } else if (((Double) i[0]).doubleValue() <= 0.7464455) {
	    p = WekaClassifier1212_all.N24a2423c111(i);
	    } else if (((Double) i[0]).doubleValue() > 0.7464455) {
	    p = WekaClassifier1212_all.N1e8a5cf3118(i);
	    }
	    return p;
	  }
	  static double N24a2423c111(Object []i) {
	    double p = Double.NaN;
	    if (i[0] == null) {
	      p = 1;
	    } else if (((Double) i[0]).doubleValue() <= 0.24933448) {
	      p = 1;
	    } else if (((Double) i[0]).doubleValue() > 0.24933448) {
	    p = WekaClassifier1212_all.N18aa83ee112(i);
	    }
	    return p;
	  }
	  static double N18aa83ee112(Object []i) {
	    double p = Double.NaN;
	    if (i[3] == null) {
	      p = 4;
	    } else if (((Double) i[3]).doubleValue() <= 25.863903) {
	    p = WekaClassifier1212_all.N62bb8ae8113(i);
	    } else if (((Double) i[3]).doubleValue() > 25.863903) {
	    p = WekaClassifier1212_all.N48bef44a116(i);
	    }
	    return p;
	  }
	  static double N62bb8ae8113(Object []i) {
	    double p = Double.NaN;
	    if (i[0] == null) {
	      p = 4;
	    } else if (((Double) i[0]).doubleValue() <= 0.25) {
	      p = 4;
	    } else if (((Double) i[0]).doubleValue() > 0.25) {
	    p = WekaClassifier1212_all.N69cb7fc114(i);
	    }
	    return p;
	  }
	  static double N69cb7fc114(Object []i) {
	    double p = Double.NaN;
	    if (i[0] == null) {
	      p = 1;
	    } else if (((Double) i[0]).doubleValue() <= 0.4942133) {
	      p = 1;
	    } else if (((Double) i[0]).doubleValue() > 0.4942133) {
	    p = WekaClassifier1212_all.N1af304c8115(i);
	    }
	    return p;
	  }
	  static double N1af304c8115(Object []i) {
	    double p = Double.NaN;
	    if (i[0] == null) {
	      p = 4;
	    } else if (((Double) i[0]).doubleValue() <= 0.5000677) {
	      p = 4;
	    } else if (((Double) i[0]).doubleValue() > 0.5000677) {
	      p = 1;
	    }
	    return p;
	  }
	  static double N48bef44a116(Object []i) {
	    double p = Double.NaN;
	    if (i[4] == null) {
	      p = 1;
	    } else if (((Double) i[4]).doubleValue() <= 26.126293) {
	    p = WekaClassifier1212_all.N70984b95117(i);
	    } else if (((Double) i[4]).doubleValue() > 26.126293) {
	      p = 1;
	    }
	    return p;
	  }
	  static double N70984b95117(Object []i) {
	    double p = Double.NaN;
	    if (i[2] == null) {
	      p = 1;
	    } else if (((Double) i[2]).doubleValue() <= 82.38033) {
	      p = 1;
	    } else if (((Double) i[2]).doubleValue() > 82.38033) {
	      p = 2;
	    }
	    return p;
	  }
	  static double N1e8a5cf3118(Object []i) {
	    double p = Double.NaN;
	    if (i[1] == null) {
	      p = 4;
	    } else if (((Double) i[1]).doubleValue() <= 0.3699246) {
	    p = WekaClassifier1212_all.Nddc652f119(i);
	    } else if (((Double) i[1]).doubleValue() > 0.3699246) {
	    p = WekaClassifier1212_all.N284a6c0121(i);
	    }
	    return p;
	  }
	  static double Nddc652f119(Object []i) {
	    double p = Double.NaN;
	    if (i[1] == null) {
	      p = 4;
	    } else if (((Double) i[1]).doubleValue() <= 0.1413605) {
	      p = 4;
	    } else if (((Double) i[1]).doubleValue() > 0.1413605) {
	    p = WekaClassifier1212_all.N76f7c5120(i);
	    }
	    return p;
	  }
	  static double N76f7c5120(Object []i) {
	    double p = Double.NaN;
	    if (i[0] == null) {
	      p = 3;
	    } else if (((Double) i[0]).doubleValue() <= 3.8704114) {
	      p = 3;
	    } else if (((Double) i[0]).doubleValue() > 3.8704114) {
	      p = 4;
	    }
	    return p;
	  }
	  static double N284a6c0121(Object []i) {
	    double p = Double.NaN;
	    if (i[4] == null) {
	      p = 3;
	    } else if (((Double) i[4]).doubleValue() <= 322.77835) {
	    p = WekaClassifier1212_all.N52df888a122(i);
	    } else if (((Double) i[4]).doubleValue() > 322.77835) {
	    p = WekaClassifier1212_all.N6a7607a126(i);
	    }
	    return p;
	  }
	  static double N52df888a122(Object []i) {
	    double p = Double.NaN;
	    if (i[0] == null) {
	      p = 3;
	    } else if (((Double) i[0]).doubleValue() <= 3.4988773) {
	      p = 3;
	    } else if (((Double) i[0]).doubleValue() > 3.4988773) {
	    p = WekaClassifier1212_all.N517d4687123(i);
	    }
	    return p;
	  }
	  static double N517d4687123(Object []i) {
	    double p = Double.NaN;
	    if (i[1] == null) {
	      p = 4;
	    } else if (((Double) i[1]).doubleValue() <= 0.5423213) {
	    p = WekaClassifier1212_all.N77a172dc124(i);
	    } else if (((Double) i[1]).doubleValue() > 0.5423213) {
	      p = 3;
	    }
	    return p;
	  }
	  static double N77a172dc124(Object []i) {
	    double p = Double.NaN;
	    if (i[0] == null) {
	      p = 4;
	    } else if (((Double) i[0]).doubleValue() <= 4.6911006) {
	    p = WekaClassifier1212_all.N87c06e0125(i);
	    } else if (((Double) i[0]).doubleValue() > 4.6911006) {
	      p = 4;
	    }
	    return p;
	  }
	  static double N87c06e0125(Object []i) {
	    double p = Double.NaN;
	    if (i[3] == null) {
	      p = 3;
	    } else if (((Double) i[3]).doubleValue() <= 10.238629) {
	      p = 3;
	    } else if (((Double) i[3]).doubleValue() > 10.238629) {
	      p = 4;
	    }
	    return p;
	  }
	  static double N6a7607a126(Object []i) {
	    double p = Double.NaN;
	    if (i[0] == null) {
	      p = 1;
	    } else if (((Double) i[0]).doubleValue() <= 1.75) {
	      p = 1;
	    } else if (((Double) i[0]).doubleValue() > 1.75) {
	      p = 3;
	    }
	    return p;
	  }
	  static double N56aeecff127(Object []i) {
	    double p = Double.NaN;
	    if (i[1] == null) {
	      p = 1;
	    } else if (((Double) i[1]).doubleValue() <= 40.30117) {
	    p = WekaClassifier1212_all.N764985ce128(i);
	    } else if (((Double) i[1]).doubleValue() > 40.30117) {
	    p = WekaClassifier1212_all.N22d215175(i);
	    }
	    return p;
	  }
	  static double N764985ce128(Object []i) {
	    double p = Double.NaN;
	    if (i[0] == null) {
	      p = 1;
	    } else if (((Double) i[0]).doubleValue() <= 1.9904691) {
	    p = WekaClassifier1212_all.N54efd40d129(i);
	    } else if (((Double) i[0]).doubleValue() > 1.9904691) {
	    p = WekaClassifier1212_all.N4928ef7d157(i);
	    }
	    return p;
	  }
	  static double N54efd40d129(Object []i) {
	    double p = Double.NaN;
	    if (i[3] == null) {
	      p = 1;
	    } else if (((Double) i[3]).doubleValue() <= 6262.589) {
	    p = WekaClassifier1212_all.N4d4acd0b130(i);
	    } else if (((Double) i[3]).doubleValue() > 6262.589) {
	    p = WekaClassifier1212_all.N598e915a155(i);
	    }
	    return p;
	  }
	  static double N4d4acd0b130(Object []i) {
	    double p = Double.NaN;
	    if (i[4] == null) {
	      p = 1;
	    } else if (((Double) i[4]).doubleValue() <= 266.06415) {
	    p = WekaClassifier1212_all.N69dbb4d1131(i);
	    } else if (((Double) i[4]).doubleValue() > 266.06415) {
	    p = WekaClassifier1212_all.N7773bb48148(i);
	    }
	    return p;
	  }
	  static double N69dbb4d1131(Object []i) {
	    double p = Double.NaN;
	    if (i[1] == null) {
	      p = 1;
	    } else if (((Double) i[1]).doubleValue() <= 13.824873) {
	    p = WekaClassifier1212_all.N573c3ba2132(i);
	    } else if (((Double) i[1]).doubleValue() > 13.824873) {
	      p = 1;
	    }
	    return p;
	  }
	  static double N573c3ba2132(Object []i) {
	    double p = Double.NaN;
	    if (i[2] == null) {
	      p = 1;
	    } else if (((Double) i[2]).doubleValue() <= 707.00397) {
	    p = WekaClassifier1212_all.N336f356c133(i);
	    } else if (((Double) i[2]).doubleValue() > 707.00397) {
	    p = WekaClassifier1212_all.N7e2ac92f139(i);
	    }
	    return p;
	  }
	  static double N336f356c133(Object []i) {
	    double p = Double.NaN;
	    if (i[0] == null) {
	      p = 1;
	    } else if (((Double) i[0]).doubleValue() <= 1.1809734) {
	    p = WekaClassifier1212_all.N4a1c5fd5134(i);
	    } else if (((Double) i[0]).doubleValue() > 1.1809734) {
	    p = WekaClassifier1212_all.N7bb2f811137(i);
	    }
	    return p;
	  }
	  static double N4a1c5fd5134(Object []i) {
	    double p = Double.NaN;
	    if (i[1] == null) {
	      p = 3;
	    } else if (((Double) i[1]).doubleValue() <= 2.8065119) {
	    p = WekaClassifier1212_all.Ncd7bef6135(i);
	    } else if (((Double) i[1]).doubleValue() > 2.8065119) {
	      p = 1;
	    }
	    return p;
	  }
	  static double Ncd7bef6135(Object []i) {
	    double p = Double.NaN;
	    if (i[0] == null) {
	      p = 0;
	    } else if (((Double) i[0]).doubleValue() <= 0.25) {
	    p = WekaClassifier1212_all.N283a0f10136(i);
	    } else if (((Double) i[0]).doubleValue() > 0.25) {
	      p = 3;
	    }
	    return p;
	  }
	  static double N283a0f10136(Object []i) {
	    double p = Double.NaN;
	    if (i[3] == null) {
	      p = 0;
	    } else if (((Double) i[3]).doubleValue() <= 42.279095) {
	      p = 0;
	    } else if (((Double) i[3]).doubleValue() > 42.279095) {
	      p = 4;
	    }
	    return p;
	  }
	  static double N7bb2f811137(Object []i) {
	    double p = Double.NaN;
	    if (i[0] == null) {
	      p = 3;
	    } else if (((Double) i[0]).doubleValue() <= 1.453537) {
	    p = WekaClassifier1212_all.N22bc6389138(i);
	    } else if (((Double) i[0]).doubleValue() > 1.453537) {
	      p = 3;
	    }
	    return p;
	  }
	  static double N22bc6389138(Object []i) {
	    double p = Double.NaN;
	    if (i[4] == null) {
	      p = 3;
	    } else if (((Double) i[4]).doubleValue() <= 65.82854) {
	      p = 3;
	    } else if (((Double) i[4]).doubleValue() > 65.82854) {
	      p = 1;
	    }
	    return p;
	  }
	  static double N7e2ac92f139(Object []i) {
	    double p = Double.NaN;
	    if (i[1] == null) {
	      p = 2;
	    } else if (((Double) i[1]).doubleValue() <= 7.1301756) {
	    p = WekaClassifier1212_all.N2afe6d5f140(i);
	    } else if (((Double) i[1]).doubleValue() > 7.1301756) {
	    p = WekaClassifier1212_all.N528c0d5d143(i);
	    }
	    return p;
	  }
	  static double N2afe6d5f140(Object []i) {
	    double p = Double.NaN;
	    if (i[4] == null) {
	      p = 2;
	    } else if (((Double) i[4]).doubleValue() <= 133.53987) {
	    p = WekaClassifier1212_all.N25be8e06141(i);
	    } else if (((Double) i[4]).doubleValue() > 133.53987) {
	      p = 2;
	    }
	    return p;
	  }
	  static double N25be8e06141(Object []i) {
	    double p = Double.NaN;
	    if (i[4] == null) {
	      p = 2;
	    } else if (((Double) i[4]).doubleValue() <= 82.38073) {
	    p = WekaClassifier1212_all.N15e3f46142(i);
	    } else if (((Double) i[4]).doubleValue() > 82.38073) {
	      p = 3;
	    }
	    return p;
	  }
	  static double N15e3f46142(Object []i) {
	    double p = Double.NaN;
	    if (i[2] == null) {
	      p = 3;
	    } else if (((Double) i[2]).doubleValue() <= 964.8934) {
	      p = 3;
	    } else if (((Double) i[2]).doubleValue() > 964.8934) {
	      p = 2;
	    }
	    return p;
	  }
	  static double N528c0d5d143(Object []i) {
	    double p = Double.NaN;
	    if (i[2] == null) {
	      p = 3;
	    } else if (((Double) i[2]).doubleValue() <= 3933.6143) {
	    p = WekaClassifier1212_all.N68c17f01144(i);
	    } else if (((Double) i[2]).doubleValue() > 3933.6143) {
	    p = WekaClassifier1212_all.N3d8c4d8e146(i);
	    }
	    return p;
	  }
	  static double N68c17f01144(Object []i) {
	    double p = Double.NaN;
	    if (i[3] == null) {
	      p = 3;
	    } else if (((Double) i[3]).doubleValue() <= 934.39484) {
	    p = WekaClassifier1212_all.N77795061145(i);
	    } else if (((Double) i[3]).doubleValue() > 934.39484) {
	      p = 2;
	    }
	    return p;
	  }
	  static double N77795061145(Object []i) {
	    double p = Double.NaN;
	    if (i[1] == null) {
	      p = 1;
	    } else if (((Double) i[1]).doubleValue() <= 8.407468) {
	      p = 1;
	    } else if (((Double) i[1]).doubleValue() > 8.407468) {
	      p = 3;
	    }
	    return p;
	  }
	  static double N3d8c4d8e146(Object []i) {
	    double p = Double.NaN;
	    if (i[4] == null) {
	      p = 1;
	    } else if (((Double) i[4]).doubleValue() <= 144.24121) {
	    p = WekaClassifier1212_all.N4637c533147(i);
	    } else if (((Double) i[4]).doubleValue() > 144.24121) {
	      p = 1;
	    }
	    return p;
	  }
	  static double N4637c533147(Object []i) {
	    double p = Double.NaN;
	    if (i[3] == null) {
	      p = 1;
	    } else if (((Double) i[3]).doubleValue() <= 647.01215) {
	      p = 1;
	    } else if (((Double) i[3]).doubleValue() > 647.01215) {
	      p = 2;
	    }
	    return p;
	  }
	  static double N7773bb48148(Object []i) {
	    double p = Double.NaN;
	    if (i[2] == null) {
	      p = 1;
	    } else if (((Double) i[2]).doubleValue() <= 375.8927) {
	      p = 1;
	    } else if (((Double) i[2]).doubleValue() > 375.8927) {
	    p = WekaClassifier1212_all.N4f0cb13c149(i);
	    }
	    return p;
	  }
	  static double N4f0cb13c149(Object []i) {
	    double p = Double.NaN;
	    if (i[1] == null) {
	      p = 2;
	    } else if (((Double) i[1]).doubleValue() <= 10.36658) {
	    p = WekaClassifier1212_all.N4a4802af150(i);
	    } else if (((Double) i[1]).doubleValue() > 10.36658) {
	      p = 1;
	    }
	    return p;
	  }
	  static double N4a4802af150(Object []i) {
	    double p = Double.NaN;
	    if (i[0] == null) {
	      p = 1;
	    } else if (((Double) i[0]).doubleValue() <= 1.1636943) {
	    p = WekaClassifier1212_all.N3da85542151(i);
	    } else if (((Double) i[0]).doubleValue() > 1.1636943) {
	    p = WekaClassifier1212_all.N3dbd56d0154(i);
	    }
	    return p;
	  }
	  static double N3da85542151(Object []i) {
	    double p = Double.NaN;
	    if (i[3] == null) {
	      p = 1;
	    } else if (((Double) i[3]).doubleValue() <= 461.06396) {
	    p = WekaClassifier1212_all.N76757fad152(i);
	    } else if (((Double) i[3]).doubleValue() > 461.06396) {
	    p = WekaClassifier1212_all.N1c11739d153(i);
	    }
	    return p;
	  }
	  static double N76757fad152(Object []i) {
	    double p = Double.NaN;
	    if (i[4] == null) {
	      p = 1;
	    } else if (((Double) i[4]).doubleValue() <= 617.11005) {
	      p = 1;
	    } else if (((Double) i[4]).doubleValue() > 617.11005) {
	      p = 2;
	    }
	    return p;
	  }
	  static double N1c11739d153(Object []i) {
	    double p = Double.NaN;
	    if (i[2] == null) {
	      p = 3;
	    } else if (((Double) i[2]).doubleValue() <= 746.32025) {
	      p = 3;
	    } else if (((Double) i[2]).doubleValue() > 746.32025) {
	      p = 1;
	    }
	    return p;
	  }
	  static double N3dbd56d0154(Object []i) {
	    double p = Double.NaN;
	    if (i[0] == null) {
	      p = 2;
	    } else if (((Double) i[0]).doubleValue() <= 1.718995) {
	      p = 2;
	    } else if (((Double) i[0]).doubleValue() > 1.718995) {
	      p = 3;
	    }
	    return p;
	  }
	  static double N598e915a155(Object []i) {
	    double p = Double.NaN;
	    if (i[2] == null) {
	      p = 2;
	    } else if (((Double) i[2]).doubleValue() <= 9003.006) {
	      p = 2;
	    } else if (((Double) i[2]).doubleValue() > 9003.006) {
	    p = WekaClassifier1212_all.N1ee8d9a5156(i);
	    }
	    return p;
	  }
	  static double N1ee8d9a5156(Object []i) {
	    double p = Double.NaN;
	    if (i[0] == null) {
	      p = 1;
	    } else if (((Double) i[0]).doubleValue() <= 1.657554) {
	      p = 1;
	    } else if (((Double) i[0]).doubleValue() > 1.657554) {
	      p = 2;
	    }
	    return p;
	  }
	  static double N4928ef7d157(Object []i) {
	    double p = Double.NaN;
	    if (i[3] == null) {
	      p = 3;
	    } else if (((Double) i[3]).doubleValue() <= 4911.192) {
	    p = WekaClassifier1212_all.N1e831d11158(i);
	    } else if (((Double) i[3]).doubleValue() > 4911.192) {
	      p = 2;
	    }
	    return p;
	  }
	  static double N1e831d11158(Object []i) {
	    double p = Double.NaN;
	    if (i[1] == null) {
	      p = 3;
	    } else if (((Double) i[1]).doubleValue() <= 13.73735) {
	    p = WekaClassifier1212_all.N31e956bd159(i);
	    } else if (((Double) i[1]).doubleValue() > 13.73735) {
	    p = WekaClassifier1212_all.N7083ca27167(i);
	    }
	    return p;
	  }
	  static double N31e956bd159(Object []i) {
	    double p = Double.NaN;
	    if (i[0] == null) {
	      p = 3;
	    } else if (((Double) i[0]).doubleValue() <= 6.1620193) {
	    p = WekaClassifier1212_all.N4e3dabe4160(i);
	    } else if (((Double) i[0]).doubleValue() > 6.1620193) {
	    p = WekaClassifier1212_all.Ne437ff0164(i);
	    }
	    return p;
	  }
	  static double N4e3dabe4160(Object []i) {
	    double p = Double.NaN;
	    if (i[0] == null) {
	      p = 3;
	    } else if (((Double) i[0]).doubleValue() <= 2.245981) {
	    p = WekaClassifier1212_all.N32e02ddd161(i);
	    } else if (((Double) i[0]).doubleValue() > 2.245981) {
	      p = 3;
	    }
	    return p;
	  }
	  static double N32e02ddd161(Object []i) {
	    double p = Double.NaN;
	    if (i[0] == null) {
	      p = 3;
	    } else if (((Double) i[0]).doubleValue() <= 2.0) {
	    p = WekaClassifier1212_all.N1be32243162(i);
	    } else if (((Double) i[0]).doubleValue() > 2.0) {
	    p = WekaClassifier1212_all.N5cde6b02163(i);
	    }
	    return p;
	  }
	  static double N1be32243162(Object []i) {
	    double p = Double.NaN;
	    if (i[4] == null) {
	      p = 3;
	    } else if (((Double) i[4]).doubleValue() <= 1170.556) {
	      p = 3;
	    } else if (((Double) i[4]).doubleValue() > 1170.556) {
	      p = 1;
	    }
	    return p;
	  }
	  static double N5cde6b02163(Object []i) {
	    double p = Double.NaN;
	    if (i[2] == null) {
	      p = 1;
	    } else if (((Double) i[2]).doubleValue() <= 410.70416) {
	      p = 1;
	    } else if (((Double) i[2]).doubleValue() > 410.70416) {
	      p = 2;
	    }
	    return p;
	  }
	  static double Ne437ff0164(Object []i) {
	    double p = Double.NaN;
	    if (i[0] == null) {
	      p = 3;
	    } else if (((Double) i[0]).doubleValue() <= 9.263504) {
	    p = WekaClassifier1212_all.N71846ce0165(i);
	    } else if (((Double) i[0]).doubleValue() > 9.263504) {
	      p = 4;
	    }
	    return p;
	  }
	  static double N71846ce0165(Object []i) {
	    double p = Double.NaN;
	    if (i[4] == null) {
	      p = 4;
	    } else if (((Double) i[4]).doubleValue() <= 17.647509) {
	      p = 4;
	    } else if (((Double) i[4]).doubleValue() > 17.647509) {
	    p = WekaClassifier1212_all.N2d082059166(i);
	    }
	    return p;
	  }
	  static double N2d082059166(Object []i) {
	    double p = Double.NaN;
	    if (i[4] == null) {
	      p = 3;
	    } else if (((Double) i[4]).doubleValue() <= 424.00308) {
	      p = 3;
	    } else if (((Double) i[4]).doubleValue() > 424.00308) {
	      p = 2;
	    }
	    return p;
	  }
	  static double N7083ca27167(Object []i) {
	    double p = Double.NaN;
	    if (i[0] == null) {
	      p = 1;
	    } else if (((Double) i[0]).doubleValue() <= 2.96579) {
	    p = WekaClassifier1212_all.N5c4d0026168(i);
	    } else if (((Double) i[0]).doubleValue() > 2.96579) {
	      p = 3;
	    }
	    return p;
	  }
	  static double N5c4d0026168(Object []i) {
	    double p = Double.NaN;
	    if (i[2] == null) {
	      p = 1;
	    } else if (((Double) i[2]).doubleValue() <= 5229.643) {
	    p = WekaClassifier1212_all.N4344ee21169(i);
	    } else if (((Double) i[2]).doubleValue() > 5229.643) {
	      p = 1;
	    }
	    return p;
	  }
	  static double N4344ee21169(Object []i) {
	    double p = Double.NaN;
	    if (i[0] == null) {
	      p = 1;
	    } else if (((Double) i[0]).doubleValue() <= 2.623043) {
	    p = WekaClassifier1212_all.N626ddb07170(i);
	    } else if (((Double) i[0]).doubleValue() > 2.623043) {
	      p = 3;
	    }
	    return p;
	  }
	  static double N626ddb07170(Object []i) {
	    double p = Double.NaN;
	    if (i[1] == null) {
	      p = 1;
	    } else if (((Double) i[1]).doubleValue() <= 23.674126) {
	    p = WekaClassifier1212_all.N1a46db0d171(i);
	    } else if (((Double) i[1]).doubleValue() > 23.674126) {
	      p = 3;
	    }
	    return p;
	  }
	  static double N1a46db0d171(Object []i) {
	    double p = Double.NaN;
	    if (i[1] == null) {
	      p = 1;
	    } else if (((Double) i[1]).doubleValue() <= 17.155437) {
	    p = WekaClassifier1212_all.N21d73ff5172(i);
	    } else if (((Double) i[1]).doubleValue() > 17.155437) {
	      p = 1;
	    }
	    return p;
	  }
	  static double N21d73ff5172(Object []i) {
	    double p = Double.NaN;
	    if (i[4] == null) {
	      p = 3;
	    } else if (((Double) i[4]).doubleValue() <= 1733.4509) {
	    p = WekaClassifier1212_all.N3aa7ff2e173(i);
	    } else if (((Double) i[4]).doubleValue() > 1733.4509) {
	      p = 1;
	    }
	    return p;
	  }
	  static double N3aa7ff2e173(Object []i) {
	    double p = Double.NaN;
	    if (i[0] == null) {
	      p = 1;
	    } else if (((Double) i[0]).doubleValue() <= 2.4003756) {
	    p = WekaClassifier1212_all.N6b624317174(i);
	    } else if (((Double) i[0]).doubleValue() > 2.4003756) {
	      p = 3;
	    }
	    return p;
	  }
	  static double N6b624317174(Object []i) {
	    double p = Double.NaN;
	    if (i[1] == null) {
	      p = 1;
	    } else if (((Double) i[1]).doubleValue() <= 16.332695) {
	      p = 1;
	    } else if (((Double) i[1]).doubleValue() > 16.332695) {
	      p = 3;
	    }
	    return p;
	  }
	  static double N22d215175(Object []i) {
	    double p = Double.NaN;
	    if (i[2] == null) {
	      p = 2;
	    } else if (((Double) i[2]).doubleValue() <= 10315.634) {
	    p = WekaClassifier1212_all.N6e0e60c4176(i);
	    } else if (((Double) i[2]).doubleValue() > 10315.634) {
	    p = WekaClassifier1212_all.N56cfd14a183(i);
	    }
	    return p;
	  }
	  static double N6e0e60c4176(Object []i) {
	    double p = Double.NaN;
	    if (i[4] == null) {
	      p = 2;
	    } else if (((Double) i[4]).doubleValue() <= 1616.533) {
	    p = WekaClassifier1212_all.N71f31c4e177(i);
	    } else if (((Double) i[4]).doubleValue() > 1616.533) {
	      p = 2;
	    }
	    return p;
	  }
	  static double N71f31c4e177(Object []i) {
	    double p = Double.NaN;
	    if (i[3] == null) {
	      p = 2;
	    } else if (((Double) i[3]).doubleValue() <= 3049.1848) {
	    p = WekaClassifier1212_all.Nfc77f54178(i);
	    } else if (((Double) i[3]).doubleValue() > 3049.1848) {
	    p = WekaClassifier1212_all.N7a9fa239181(i);
	    }
	    return p;
	  }
	  static double Nfc77f54178(Object []i) {
	    double p = Double.NaN;
	    if (i[1] == null) {
	      p = 3;
	    } else if (((Double) i[1]).doubleValue() <= 58.537445) {
	    p = WekaClassifier1212_all.N72786be3179(i);
	    } else if (((Double) i[1]).doubleValue() > 58.537445) {
	      p = 2;
	    }
	    return p;
	  }
	  static double N72786be3179(Object []i) {
	    double p = Double.NaN;
	    if (i[0] == null) {
	      p = 2;
	    } else if (((Double) i[0]).doubleValue() <= 3.371864) {
	    p = WekaClassifier1212_all.N3ff33ecb180(i);
	    } else if (((Double) i[0]).doubleValue() > 3.371864) {
	      p = 3;
	    }
	    return p;
	  }
	  static double N3ff33ecb180(Object []i) {
	    double p = Double.NaN;
	    if (i[3] == null) {
	      p = 3;
	    } else if (((Double) i[3]).doubleValue() <= 1628.7451) {
	      p = 3;
	    } else if (((Double) i[3]).doubleValue() > 1628.7451) {
	      p = 2;
	    }
	    return p;
	  }
	  static double N7a9fa239181(Object []i) {
	    double p = Double.NaN;
	    if (i[2] == null) {
	      p = 1;
	    } else if (((Double) i[2]).doubleValue() <= 370.0456) {
	    p = WekaClassifier1212_all.N6538b14182(i);
	    } else if (((Double) i[2]).doubleValue() > 370.0456) {
	      p = 2;
	    }
	    return p;
	  }
	  static double N6538b14182(Object []i) {
	    double p = Double.NaN;
	    if (i[3] == null) {
	      p = 2;
	    } else if (((Double) i[3]).doubleValue() <= 22417.96) {
	      p = 2;
	    } else if (((Double) i[3]).doubleValue() > 22417.96) {
	      p = 1;
	    }
	    return p;
	  }
	  static double N56cfd14a183(Object []i) {
	    double p = Double.NaN;
	    if (i[0] == null) {
	      p = 1;
	    } else if (((Double) i[0]).doubleValue() <= 1.891811) {
	    p = WekaClassifier1212_all.N65b57dcc184(i);
	    } else if (((Double) i[0]).doubleValue() > 1.891811) {
	      p = 2;
	    }
	    return p;
	  }
	  static double N65b57dcc184(Object []i) {
	    double p = Double.NaN;
	    if (i[3] == null) {
	      p = 1;
	    } else if (((Double) i[3]).doubleValue() <= 7080.8022) {
	    p = WekaClassifier1212_all.N6e56103e185(i);
	    } else if (((Double) i[3]).doubleValue() > 7080.8022) {
	      p = 2;
	    }
	    return p;
	  }
	  static double N6e56103e185(Object []i) {
	    double p = Double.NaN;
	    if (i[1] == null) {
	      p = 1;
	    } else if (((Double) i[1]).doubleValue() <= 66.313866) {
	      p = 1;
	    } else if (((Double) i[1]).doubleValue() > 66.313866) {
	      p = 2;
	    }
	    return p;
	  }
	}