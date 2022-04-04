package easy;

public class L733 {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int val = image[sr][sc];
        flood(image,sr,sc,val,newColor);
        return image;
    }

    private void flood(int[][] image, int sr, int sc, int val, int newColor) {
        if (sr<0||sr>=image.length||sc<0||sc>=image[sr].length||val==newColor){
            return;
        }
        if (image[sr][sc]==val){
            image[sr][sc] = newColor;
            flood(image,sr-1,sc,val,newColor);
            flood(image,sr+1,sc,val,newColor);
            flood(image,sr,sc+1,val,newColor);
            flood(image,sr,sc-1,val,newColor);
        }
    }
}
