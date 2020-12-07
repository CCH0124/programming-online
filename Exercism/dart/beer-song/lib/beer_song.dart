class BeerSong {
  List<String> recite(int bottles, int freq) {
    List<String> list = [];
    for (int i = 0; i < freq; i++) {
      int num = bottles - i;

      if (num > 2) {
        list.add('$num bottles of beer on the wall, $num bottles of beer.');
        list.add('Take one down and pass it around, ${num - 1} bottles of beer on the wall.');
      } else if (num == 2) {
        list.add('2 bottles of beer on the wall, 2 bottles of beer.');
        list.add('Take one down and pass it around, 1 bottle of beer on the wall.');
      } else if (num == 1) {
        list.add('1 bottle of beer on the wall, 1 bottle of beer.');
        list.add('Take it down and pass it around, no more bottles of beer on the wall.');
      } else if (num == 0) {
        list.add('No more bottles of beer on the wall, no more bottles of beer.');
        list.add('Go to the store and buy some more, 99 bottles of beer on the wall.');
      }

      if (freq > 1 && i != freq - 1) {
        list.add('');
      }
    }

    return list;
  }
}
