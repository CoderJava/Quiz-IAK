package com.iak.quiziak.ui.question.dashboard.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.iak.quiziak.R;
import com.iak.quiziak.model.Question;

import java.util.List;

/**
 * Created by yudisetiawan on 11/26/17.
 */

public class AdapterDashboardQuestion extends RecyclerView.Adapter<AdapterDashboardQuestion.ViewHolderDashboardQuestion> {

    private List<Question> questions;
    private ListenerAdapterDashboardQuestion listenerAdapterDashboardQuestion;

    public AdapterDashboardQuestion(List<Question> questions,
                                    ListenerAdapterDashboardQuestion listenerAdapterDashboardQuestion) {
        this.questions = questions;
        this.listenerAdapterDashboardQuestion = listenerAdapterDashboardQuestion;
    }

    @Override
    public ViewHolderDashboardQuestion onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolderDashboardQuestion(
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_dashboard_question, null)
        );
    }

    @Override
    public void onBindViewHolder(ViewHolderDashboardQuestion holder, int position) {
        Question question = questions.get(position);
        holder.textViewNumberQuestionViewHolderDashboardQuestion
                .setText(String.valueOf(question.getNumber()));
        holder.textViewQuestionTitleViewHolderDashboardQuestion
                .setText(question.getTitle());
        boolean isEverOpened = question.isEverOpened();
        if (isEverOpened) {
            boolean isRightAnswer = question.isRightAnswer();
            if (isRightAnswer) {
                holder.imageViewRightAnswerViewHolderDashboardQuestion.setVisibility(View.VISIBLE);
                holder.imageViewWrongAnswerViewHolderDashboardQuestion.setVisibility(View.INVISIBLE);
            } else {
                holder.imageViewRightAnswerViewHolderDashboardQuestion.setVisibility(View.INVISIBLE);
                holder.imageViewWrongAnswerViewHolderDashboardQuestion.setVisibility(View.VISIBLE);
            }
        } else {
            holder.imageViewRightAnswerViewHolderDashboardQuestion.setVisibility(View.INVISIBLE);
            holder.imageViewWrongAnswerViewHolderDashboardQuestion.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return questions.size();
    }

    class ViewHolderDashboardQuestion extends RecyclerView.ViewHolder implements View.OnClickListener {

        private RelativeLayout relativeLayoutContainerViewHolderDashboardQuestion;
        private TextView textViewNumberQuestionViewHolderDashboardQuestion;
        private TextView textViewQuestionTitleViewHolderDashboardQuestion;
        private ImageView imageViewRightAnswerViewHolderDashboardQuestion;
        private ImageView imageViewWrongAnswerViewHolderDashboardQuestion;

        ViewHolderDashboardQuestion(View itemView) {
            super(itemView);
            initViews(itemView);
            initListeners();
        }

        private void initListeners() {
            relativeLayoutContainerViewHolderDashboardQuestion.setOnClickListener(this);
        }

        private void initViews(View itemView) {
            relativeLayoutContainerViewHolderDashboardQuestion = (RelativeLayout) itemView.findViewById(R.id.relative_layout_container_item_dashboard_question);
            textViewNumberQuestionViewHolderDashboardQuestion = (TextView) itemView.findViewById(R.id.text_view_number_question_item_dashboard_question);
            textViewQuestionTitleViewHolderDashboardQuestion = (TextView) itemView.findViewById(R.id.text_view_question_title_item_dashboard_question);
            imageViewRightAnswerViewHolderDashboardQuestion = (ImageView) itemView.findViewById(R.id.image_view_right_answer_item_dashboard_question);
            imageViewWrongAnswerViewHolderDashboardQuestion = (ImageView) itemView.findViewById(R.id.image_view_wrong_answer_item_dashboard_question);
        }

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.relative_layout_container_item_dashboard_question:
                    listenerAdapterDashboardQuestion
                            .onClickItem(questions.get(getAdapterPosition()).getNumber());
                    break;
            }
        }
    }

    public interface ListenerAdapterDashboardQuestion {

        void onClickItem(int numberQuestion);

    }

}
