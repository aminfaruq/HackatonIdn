package id.co.maminfaruq.hackatonidn.model;

import android.os.Parcel;
import android.os.Parcelable;

public class BeritaModel implements Parcelable {
    private String publishedAt,author,urlToImage,description,source,title,url,content;

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.publishedAt);
        dest.writeString(this.author);
        dest.writeString(this.urlToImage);
        dest.writeString(this.description);
        dest.writeString(this.source);
        dest.writeString(this.title);
        dest.writeString(this.url);
        dest.writeString(this.content);
    }

    public BeritaModel() {
    }

    protected BeritaModel(Parcel in) {
        this.publishedAt = in.readString();
        this.author = in.readString();
        this.urlToImage = in.readString();
        this.description = in.readString();
        this.source = in.readString();
        this.title = in.readString();
        this.url = in.readString();
        this.content = in.readString();
    }

    public static final Parcelable.Creator<BeritaModel> CREATOR = new Parcelable.Creator<BeritaModel>() {
        @Override
        public BeritaModel createFromParcel(Parcel source) {
            return new BeritaModel(source);
        }

        @Override
        public BeritaModel[] newArray(int size) {
            return new BeritaModel[size];
        }
    };
}
