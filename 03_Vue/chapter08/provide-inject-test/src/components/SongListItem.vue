<template>
  <li>
    <!-- song의 done이 true면 icons의 checked 내에 있는 값으로 클래스 지정 -->
    <!-- song의 done이 false면 icons의 unchecked 내에 있는 값으로 클래스 지정 -->
    <i :class="song.done ? icons.checked : icons.unchecked">{{ song.title }}</i>
  </li>
</template>

<script>
export default {
  name: 'SongListItem',
  // 부모에서 provide한 항목을 inject로 가져올 수 있다.
  inject: ['icons'],
  props: ['song'],
};
</script>
