package sujan.maka.com.recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class MoviesAdapterNew extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Movie> movieList;
    private final int TYPE_HEADER = 0;
    private final int TYPE_MIDDLE = 1;
    private final int TYPE_FOOTER = 2;

    public MoviesAdapterNew(List<Movie> movieList) {
        this.movieList = movieList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == TYPE_HEADER) {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_list_row_header, parent, false);
            return new ViewHolderHeader(itemView);

        } else if (viewType == TYPE_MIDDLE) {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_list_row, parent, false);
            return new ViewHolderMiddle(itemView);

        } else if (viewType == TYPE_FOOTER) {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_list_row_footer, parent ,false);
            return new ViewHolderFooter(itemView);
        }
        throw new RuntimeException("");
    }

    @Override
    public void onBindViewHolder(@NonNull  RecyclerView.ViewHolder holder, int position) {


        if (holder instanceof ViewHolderHeader) {
            final ViewHolderHeader viewHoldersHeader = ((ViewHolderHeader) holder);


        } else if (holder instanceof ViewHolderMiddle) {
            ViewHolderMiddle viewHolder = (ViewHolderMiddle) holder;
            Movie movie = movieList.get(position);
            Log.e( "onBindViewHolder: ",movieList.get(position).getYear() );
            viewHolder.title.setText(movie.getTitle());
            viewHolder.genre.setText(movie.getGenre());
            viewHolder.year.setText(movie.getYear());

        } else if (holder instanceof ViewHolderFooter){
            final ViewHolderFooter viewHolderFooter = ((ViewHolderFooter) holder);
        }


    }


    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPE_HEADER;
        } else if (position == (movieList.size()-1)) {
            return TYPE_FOOTER;
        } else {
            return TYPE_MIDDLE;
        }
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

     class ViewHolderHeader extends RecyclerView.ViewHolder {
         ViewHolderHeader(View itemView) {
            super(itemView);
        }
    }


     class ViewHolderMiddle extends RecyclerView.ViewHolder {

        public TextView title, year, genre;

        public ViewHolderMiddle(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
            genre = (TextView) itemView.findViewById(R.id.genre);
            year = (TextView) itemView.findViewById(R.id.year);

        }
    }


     class ViewHolderFooter extends RecyclerView.ViewHolder {
         ViewHolderFooter(View itemView) {
            super(itemView);
        }
    }
}
